package Ch03.Sec07.Part03.case_01

import Ch02.Sec04.User

class UserService(
    private val userRepo: UserRepo
) {

    fun login(email: String, password: String): User {
        val existsed = userRepo.checkIfUserExisted(email, password)

        if (!existsed) {
            // AuthenticationFailureException 예외 발생
        }

        val user = userRepo.getUserByEmail(email)

        return user
    }
}

class UserRepo(
    private val emailValidation: Validation,
    private val passwordValidation: Validation
) {

    fun checkIfUserExisted(email: String, password: String): Boolean {
        if (!emailValidation.validate(email)) {
            // InvalidEmailException 예외 발생
        }

        if (!passwordValidation.validate(password)) {
            // InvalidPasswordException 예외 발생
        }

        // 사용자 정보에서 해당 email, password가 존재하는 지 확인하는 코드 생략
        TODO()
    }

    fun getUserByEmail(email: String): User {
        if (!emailValidation.validate(email)) {
            // InvalidEmailException 예외 발생
        }

        // 주어진 이메일에 해당하는 사용자가 있는지 확인하는 코드 생략
        TODO()
    }
}

interface Validation {
    fun validate(input: String): Boolean
}

class EmailValidation: Validation {
    override fun validate(input: String): Boolean = TODO("Not yet implemented")
}

class PasswordValidation: Validation {
    override fun validate(input: String): Boolean = TODO("Not yet implemented")
}
