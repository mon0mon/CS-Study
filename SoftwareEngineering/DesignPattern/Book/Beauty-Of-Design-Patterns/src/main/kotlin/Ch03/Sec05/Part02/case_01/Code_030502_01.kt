package Ch03.Sec05.Part02.case_01

fun main() {
    val messageSender = SmsSender()

    val notification = Notification(messageSender)
}

class Notification(
    val messageSender: MessageSender
) {

    fun sendMessage(cellphone: String, message: String) {
        messageSender.send(cellphone, message)
    }
}

interface MessageSender {
    fun send(cellphone: String, message: String)
}

// 문자 메시지 발송 클래스
class SmsSender: MessageSender {

    override fun send(cellphone: String, message: String): Unit = TODO("Not yet implemented")
}

// 내부 문자 발송 클래스
class InboxSender: MessageSender {

    override fun send(cellphone: String, message: String): Unit = TODO("Not yet implemented")
}
