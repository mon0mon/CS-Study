package Ch02.Sec07.case_01

import java.io.FileWriter

abstract class Logger(
    open val name: String,
    open val enabled: Boolean,
    open val minPermittedLevel: Level
) {

    fun log(level: Level, message: String) {
        val loggable = enabled && level.intValue >= minPermittedLevel.intValue

        if (loggable.not()) return

        doLog(level, message)
    }

    protected abstract fun doLog(level: Level, message: String)
}

// 하위 클래스: 파일로 출력
class FileLogger(
    override val name: String,
    override val enabled: Boolean,
    override val minPermittedLevel: Level,
    filePath: String
): Logger(name, enabled, minPermittedLevel) {

    private val fileWriter = FileWriter(filePath)

    override fun doLog(level: Level, message: String) {
        // level과 message를 형식화하고 파일로 출력
        fileWriter.write(message)
    }
}

// 하위 클래스: Kafka와 같은 메시지 대기열로 출력
class MessageQueueLogger(
    override val name: String,
    override val enabled: Boolean,
    override val minPermittedLevel: Level,
    val messageQueueClient: MessageQueueClient
): Logger(name, enabled, minPermittedLevel) {
    override fun doLog(level: Level, message: String) {
        // level과 message를 형식화하고 메시지 대기열로 전송
        messageQueueClient.send(level, message)
    }
}

enum class Level(val intValue: Int)

interface MessageQueueClient {
    fun send(level: Level, message: String)
}
