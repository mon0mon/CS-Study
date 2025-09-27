package Ch04.Sec03.Part05

import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneOffset

val SUMMER_START = OffsetDateTime.ofInstant(Instant.ofEpochMilli(0), ZoneOffset.UTC)
val SUMMER_END = OffsetDateTime.ofInstant(Instant.ofEpochMilli(10), ZoneOffset.UTC)

fun before(date: OffsetDateTime) {
    if (date.isAfter(SUMMER_START) && date.isBefore(SUMMER_END)) {
        // do something
    } else {
        // do something
    }
}

fun after(date: OffsetDateTime) {
    // 설명 변수 도입 후, 코드 이해가 더 쉬워짐
    val isSummer = date.isAfter(SUMMER_START) && date.isBefore(SUMMER_END)

    if (isSummer) {
        // do something
    } else {
        // do something
    }
}
