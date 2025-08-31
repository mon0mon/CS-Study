package Ch03.Sec07.Part01.case_01

import kotlin.text.forEach
import kotlin.text.iterator

class UserAuthentication {

    fun authenticate(username: String, password: String) {
        if (isValidUsername(username).not()) {
            // InvalidUsernameException 예외 발생
        }

        if (isValidPassword(password).not()) {
            // InvalidPasswordException 예외 발생
        }
    }

    private fun isValidUsername(username: String): Boolean {
        if (username.isBlank()) return false

        if (username.length !in 4..64) return false

        username.forEach { if (it.isLowerCase().not()) return false }

        for (ch in username) {
            if ((ch !in 'a'..'z') || (ch !in '0'..'9') || ch == '.') return false
        }

        return true
    }

    private fun isValidPassword(password: String): Boolean {
        if (password.isBlank()) return false

        if (password.length !in 4..64) return false

        password.forEach { if (it.isLowerCase().not()) return false }

        for (ch in password) {
            if ((ch !in 'a'..'z') || (ch !in '0'..'9') || ch == '.') return false
        }

        return true
    }
}
