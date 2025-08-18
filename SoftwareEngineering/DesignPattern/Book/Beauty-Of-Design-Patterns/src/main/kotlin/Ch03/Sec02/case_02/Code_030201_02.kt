package Ch03.Sec02.case_02

class Alert(
    private val alertHandlers: List<AlertHandler>
) {
    fun add(alertHandler: AlertHandler) {
        alertHandlers + alertHandler
    }

    fun check(api: String, requestCount: Long, errorCount: Long, timeOutCount: Long, duration: Long) {
        val apiStat = ApiStatInfo(api, requestCount, errorCount, duration)

        alertHandlers.forEach { it.check(apiStat) }
    }
}

data class ApiStatInfo (
    val api: String,
    val requestCount: Long,
    val errorCount: Long,
    val duration: Long
)

data class RuleInfo (
    val url: String,
    val maxErrorCount: Int,
    val maxTps: Int,
    val maxTimeoutTps: Int
)

interface AlertRule {
    fun matches(url: String): RuleInfo?
}

interface Notification {
    fun notify(level: NotificationLevel, message: String)
}

enum class NotificationLevel {
    SEVERE,   // 심각
    URGENCY, // 긴급
    NORMAL,  // 정상
    TRIVIAL  // 관련 없음
}

abstract class AlertHandler (
    protected open val rule: AlertRule,
    protected open val notification: Notification
) {
    abstract fun check(apiStatInfo: ApiStatInfo)
}

class TpsAlertHandler(
    override val rule: AlertRule,
    override val notification: Notification
) : AlertHandler(rule, notification) {
    override fun check(apiStatInfo: ApiStatInfo) {
        val tps = apiStatInfo.requestCount / apiStatInfo.duration
        val matchRule = rule.matches(apiStatInfo.api) ?: return

        if (tps > matchRule.maxTps) {
            notification.notify(NotificationLevel.URGENCY, "High TPS")
        }
    }
}

class ErrorAlertHandler(
    override val rule: AlertRule,
    override val notification: Notification
) : AlertHandler(rule, notification) {
    override fun check(apiStatInfo: ApiStatInfo) {
        val errorCount = apiStatInfo.errorCount
        val matchRule = rule.matches(apiStatInfo.api) ?: return

        if (errorCount > matchRule.maxErrorCount) {
            notification.notify(NotificationLevel.SEVERE, "High Error Count")
        }
    }
}
