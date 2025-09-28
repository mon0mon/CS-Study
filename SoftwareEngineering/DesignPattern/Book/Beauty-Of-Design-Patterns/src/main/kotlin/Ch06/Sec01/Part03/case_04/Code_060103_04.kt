package Ch06.Sec01.Part03.case_04

import java.io.File
import java.io.FileWriter

class Logger private constructor() {

    companion object {
        private val file: File = File("log.txt")
        private val writer: FileWriter = FileWriter(file, true)

        // 쓰레드 안전한 방식으로 Singleton 객체 생성
        val instance: Logger by lazy { Logger() }
    }

    // 멤버함수이기 때문에, Logger.instance를 통해서만 호출 가능
    // 따라서 다중 스레드에서 경쟁조건으로 인해 생기는 문제 예방 가능
    fun log(message: String) {
        writer.write(message)
    }
}

// Logger 클래스 응용 예시
class UserController {

    fun login(username: String, password: String) {
        // 비즈니스 논리 코드 생략
        Logger.instance.log("$username logined!")
    }
}

class OrderController {

    fun create(order: OrderVo) {
        // 비즈니스 논리 코드 생략
        Logger.instance.log("Created and order: $order")
    }
}

class OrderVo
