package Ch06.Sec01.Part03.case_03

import java.io.File
import java.io.FileWriter

class Logger(
    private val file: File = File("log.txt"),
    private val writer: FileWriter = FileWriter(file, true)
) {

    // 클래스 레벨의 잠금
    fun log(message: String) {
        synchronized(Logger::class.java) {
            writer.write(message)
        }
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
