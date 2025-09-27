package Ch04.Sec03.Part02

// 단일 함수의 매개변수가 너무 많은 경우, 가독성이 떨어짐
fun getUser(id: String?, username: String?, telephone: String?, email: String?, udid: String?, uuid: String?): User =
    TODO();
// 여러 기능으로 분할
fun getUserById(id: String): User = TODO()
fun getUserByUsername(username: String): User = TODO()
fun getUserByTelephone(telephone: String): User = TODO()
fun getUserByEmail(email: String): User = TODO()
fun getUserByUdid(udid: String): User = TODO()
fun getUserByUuid(uuid: String): User = TODO()

data class User(
    val id: Long,
    val username: String,
    val telephone: String,
    val email: String,
    val udid: String,
    val uuid: String
)
