package Ch03.Sec07.Part02.case_01

import kotlin.text.forEach
import kotlin.text.iterator

fun isValidIp(ipAddress: String): Boolean {
    if (ipAddress.isBlank()) return false

    val regex = Regex(
        "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d[1-9])\\." +
                "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d[1-9])\\." +
                "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d[1-9])\\." +
                "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d[1-9])$"
    )

    return ipAddress.matches(regex)
}

fun checkIfIpValid(ipAddress: String): Boolean {
    if (ipAddress.isBlank()) return false

    val ipUnits = ipAddress.split('.')

    if (ipUnits.size != 4) return false

    for (i in ipUnits.indices) {
        val ipUnitIntValue = ipUnits[i].toIntOrNull() ?: return false

        if (ipUnitIntValue !in 0..255) return false

        if (i == 0 && ipUnitIntValue == 0) return false
    }

    return true
}
