package Ch03.Sec05.Part03.case_01

import Ch03.Sec05.Part02.case_01.Notification
import Ch03.Sec05.Part02.case_01.SmsSender

fun main() {
    val messageSender = SmsSender() // 객체 생성
    val notification = Notification(messageSender) // 의존성 주입

    notification.sendMessage("010xxxxxxxx", "인증 번호: 1234")
}
