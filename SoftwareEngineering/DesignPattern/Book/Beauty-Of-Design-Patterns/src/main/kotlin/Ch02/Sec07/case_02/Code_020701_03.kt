package Ch02.Sec07.case_02

import java.io.FileWriter

abstract class Logger(
    open val name: String,
    open val enabled: Boolean,
    open val minPermittedLevel: Level
) {
    protected fun isLoggable(level: Level): Boolean =
        enabled && (minPermittedLevel.intValue <= level.intValue)

    open fun log(level: Level, message: String) {}
}

// 하위 클래스: 파일로 출력
class FileLogger(
    override val name: String,
    override val enabled: Boolean,
    override val minPermittedLevel: Level,
    filePath: String
) : Logger(name, enabled, minPermittedLevel) {

    private val fileWriter = FileWriter(filePath)

    override fun log(level: Level, message: String) {
        if (!isLoggable(level)) return

        // level과 message를 형식화하고 파일로 전송
        fileWriter.write(message)
    }
}

// 하위 클래스: Kafka와 같은 메시지 대기열로 출력
class MessageQueueLogger(
    override val name: String,
    override val enabled: Boolean,
    override val minPermittedLevel: Level,
    val messageQueueClient: MessageQueueClient
) : Logger(name, enabled, minPermittedLevel) {

    override fun log(level: Level, message: String) {
        if (!isLoggable(level)) return

        // level과 messag를 형식화하고 메시지 대기열로 전송
        messageQueueClient.send(level, message)
    }
}

enum class Level(val intValue: Int)

interface MessageQueueClient {
    fun send(level: Level, message: String)
}
