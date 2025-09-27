package Ch04.Sec03.Part01

import java.time.Instant
import java.util.Calendar
import java.util.Date

// 리팩터링 전 코드
fun invest(userId: Long, financialProductId: Long) {
    val calendar = Calendar.getInstance()

    calendar.time = Date.from(Instant.now())
    calendar.set(Calendar.DATE, (calendar.get(Calendar.DATE) + 1))

    if (calendar.get(Calendar.DAY_OF_MONTH) == 1) {
        return
    }

    // 생략
}

// 리팩터링 후 코드
fun invest2(userId: Long, financialProductId: Long) {
    if (isLastDayOfMonth(Date.from(Instant.now()))) {
        return;
    }

    // 생략
}

private fun isLastDayOfMonth(date: Date): Boolean {
    val calendar = Calendar.getInstance()

    calendar.time = date
    calendar.set(Calendar.DATE, (calendar.get(Calendar.DATE) + 1))

    return calendar.get(Calendar.DATE) == 1
}
