package Ch03.Sec02.case_01

class Alert(
    private val rule: AlertRule,
    private val notification: Notification
) {
    fun check(api: String, requestCount: Long, errorCount: Long, timeOutCount: Long, duration: Long) {
        val tps = requestCount / duration
        val matchRule = rule.matches(api) ?: return

        if (tps > matchRule.maxTps) notification.notify(NotificationLevel.URGENCY, "High TPS")

        if (errorCount > matchRule.maxErrorCount) notification.notify(NotificationLevel.SEVERE, "High Error Count")

        val timeOutTps = timeOutCount / duration

        if (timeOutTps > matchRule.maxTimeoutTps) notification.notify(NotificationLevel.URGENCY, "High Timeout Count")
    }
}

interface AlertRule {
    fun matches(url: String): Matcher?
}

class Matcher(
    val url: String,
    val maxErrorCount: Int,
    val maxTps: Int,
    val maxTimeoutTps: Int
)

interface Notification {
    fun notify(level: NotificationLevel, message: String)
}

enum class NotificationLevel {
    SEVERE,   // 심각
    URGENCY, // 긴급
    NORMAL,  // 정상
    TRIVIAL  // 관련 없음
}
