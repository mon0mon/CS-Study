package Ch03.Sec07.Part03.case_02

class UserService(
    private val userRepo: UserRepo,
    private val emailValidation: Validation,
    private val passwordValidation: Validation
) {

    fun login(email: String, password: String): User {
        if (!emailValidation.validate(email)) {
            // InvalidEmailException 예외 발생
        }

        if (!passwordValidation.validate(password)) {
            // InvalidPasswordException 예외 발생
        }

        val existsed = userRepo.checkIfUserExisted(email, password)

        if (!existsed) {
            // AuthenticationFailureException 예외 발생
        }

        val user = userRepo.getUserByEmail(email)
            ?: TODO() // AuthenticationFailureException 예외 발생

        if (password != user.password) {
            // AuthenticationFailureException 예외 발생
        }

        return user
    }
}

class UserRepo {

    fun checkIfUserExisted(email: String, password: String): Boolean {
        // 사용자 정보에서 해당 email, password가 존재하는 지 확인하는 코드 생략
        TODO()
    }

    fun getUserByEmail(email: String): User? {
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

class User(
    val email: String,
    val password: String
)
