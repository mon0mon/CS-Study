package Ch06.Sec01.Part03.case_01

import java.io.File
import java.io.FileWriter

class Logger(
    private val file: File = File("log.txt"),
    private val writer: FileWriter = FileWriter(file, true)
) {

    // 경쟁 조건으로 인해, 예상한 대로 동작하지 않을 가능성이 존재
    // e.g. 로그 정보가 덮어씌워지는 일이 발생할 수 있음
    fun log(message: String) {
        writer.write(message)
    }
}

// Logger 클래스 응용 예시
class UserController(
    private val logger: Logger = Logger()
) {

    fun login(username: String, password: String) {
        // 비즈니스 논리 코드 생략
        logger.log("$username logined!")
    }
}

class OrderController(
    private val logger: Logger = Logger()
) {

    fun create(order: OrderVo) {
        // 비즈니스 논리 코드 생략
        logger.log("Created and order: $order")
    }
}

class OrderVo
