package Ch02.Sec04

fun main() {
    val userFileFormatter = UserFileFormatter()

    // 실제로 동작하지 않음, 수도 코드
    userFileFormatter.format("users.txt", "formattedUsers.txt")
}

class User (
    val name: String,
    val age: Int,
    val gender: String
) {
    companion object {
        fun parseFrom(userInfoText: String): User = TODO()
    }

    fun formatToText(): String = TODO()
}

class UserFileFormatter {
    fun format(userFile: String, formattedUserFile: String) {
        // 파일을 여는 코드 생략
        val userText = ""
        val users = mutableListOf<User>()

        while (true) {
            // 파일을 읽은 내용이 userText에 들어있다고 가정
            val user = User.parseFrom(userText)
            users.add(user)
        }

        // users 목록을 나이순으로 정렬하는 코드 생략
        for (i in users.indices) {
            val user = users[i]
            val formattedUserText = user.formatToText()
            // 새로울 파일에 저장하는 코드 생략
        }

        // 파일을 닫는 코드 생략
    }
}
