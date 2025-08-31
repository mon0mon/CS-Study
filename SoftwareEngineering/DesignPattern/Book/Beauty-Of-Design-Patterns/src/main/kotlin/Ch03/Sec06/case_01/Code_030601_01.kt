package Ch03.Sec06.case_01

// 첫 번째 코드: 정규표현식 사용
fun isValidIpAddressV1(ipAddress: String): Boolean {
    if (ipAddress.isBlank()) return false

    val regex = Regex(
        "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d[1-9])\\." +
                "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d[1-9])\\." +
                "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d[1-9])\\." +
                "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d[1-9])$"
    )

    return ipAddress.matches(regex)
}

// 두 번째 코드: 기성 클래스 사용
fun isValidIpAddressV2(ipAddress: String): Boolean {
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

// 세 번째 코드: 외부 클래스 없이 직접 구현
fun isValidIpAddressV3(ipAddress: String): Boolean {
    val ipChars = ipAddress.toCharArray()
    var ipUnitIntValue = -1
    var isFirstUnit = true
    var unitsCount = 0

    for (i in ipChars.indices) {
        val c = ipChars[i]

        if (c == '.') {
            if (ipUnitIntValue !in 0..255) return false
            if (isFirstUnit && ipUnitIntValue == 0) return false
            if (isFirstUnit) isFirstUnit = false

            ipUnitIntValue = -1
            unitsCount++
            continue
        }

        if (c !in '0'..'9') return false

        if (ipUnitIntValue == -1) ipUnitIntValue = 0

        ipUnitIntValue = ipUnitIntValue * 10 + (c - '0')
    }

    if (ipUnitIntValue !in 0..255) return false
    if (unitsCount != 3) return false

    return true
}
