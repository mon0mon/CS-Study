package Ch03.Sec04.Part03.case_02

import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit
import kotlin.properties.Delegates

class Application {
    val configSource: ConfigSource = ZooKeeperConfigSource()
    val redisConfig: RedisConfig = RedisConfig(configSource)
    val kafkaConfig: KafkaConfig = KafkaConfig(configSource)
    val mysqlConfig: MysqlConfig = MysqlConfig(configSource)
}

fun main() {
    val application = Application()

    val redisConfigUpdater = ScheduledUpdater(application.redisConfig, 300, 300)
    val kafkaConfigUpdater = ScheduledUpdater(application.kafkaConfig, 60, 60)

    redisConfigUpdater.run()
    kafkaConfigUpdater.run()
}

interface Updater {
    fun update()
}

open class ConfigSource

class ZooKeeperConfigSource : ConfigSource()

class RedisConfig(
    var configSource: ConfigSource
) : Updater {
    lateinit var _address: String
    private var timeout by Delegates.notNull<Int>()

    private var maxTotal by Delegates.notNull<Int>()

    val address: String
        get() = _address
    override fun update() {
        // configSource에서 address, timeout, maxTotal을 읽어온다
    }
}

class KafkaConfig(
    val configSource: ConfigSource
) : Updater {
    override fun update(): Unit = TODO("Not yet implemented")
}

class MysqlConfig(
    val configSource: ConfigSource
) : Updater {
    override fun update(): Unit = TODO("Not yet implemented")
}

class ScheduledUpdater(
    val updater: Updater,
    val initialDelayInSeconds: Long,
    val periodInSeconds: Long
) {
    private val executor = Executors.newSingleThreadExecutor() as ScheduledExecutorService

    fun run() {
        executor.scheduleAtFixedRate({
            Runnable(function = { updater.update() })
        }, initialDelayInSeconds, periodInSeconds, TimeUnit.SECONDS)
    }
}
