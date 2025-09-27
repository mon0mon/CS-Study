package Ch04.Sec03.Part04.case_03

// 리팩토링 전 코드
fun appendSalts(passwords: List<String?>): List<String> {
    if (passwords.isEmpty()) return emptyList()

    val passwordWithSalt = mutableListOf<String>()

    for (password in passwords) {
        if (password == null) {
            continue
        }

        if (password.length < 8) {
            // do something
        } else {
            // do something
        }
    }

    return passwordWithSalt
}

// 리팩토링 후 코드: 코드의 일부분을 함수로 캡슐화
fun appendSalts2(passwords: List<String?>): List<String> {
    if (passwords.isEmpty()) return emptyList()

    val passwordWithSalt = mutableListOf<String>()

    for (password in passwords) {
        if (password == null) {
            continue
        }

        passwordWithSalt.add(appendSalt(password))
    }

    return passwordWithSalt
}

// 코틀린 함수형 패러다임에 맞게 코드를 수정
fun appendSalts3(passwords: List<String?>): List<String> {
    if (passwords.isEmpty()) return emptyList()

    return passwords.filterNotNull().map(::appendSalt)
}

private fun appendSalt(password: String): String {
    var passwordWithSalt = password

    if (password.length < 8) {
        // do something
    } else {
        // do something
    }

    return passwordWithSalt
}
