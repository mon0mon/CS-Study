package Ch03.Sec04.Part03.case_04

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

    val simpleHttpServer = SimpleHttpServer("127.0.0.1", 2389)

    simpleHttpServer.addViewer("/config", application.redisConfig)
    simpleHttpServer.addViewer("/config", application.redisConfig)
}

interface Config {
    fun update()
    fun outputInPlainText()
    fun output(): Map<String, String>
}

open class ConfigSource

class ZooKeeperConfigSource : ConfigSource()

class RedisConfig(
    var configSource: ConfigSource
) : Config {
    lateinit var _address: String
    private var timeout by Delegates.notNull<Int>()

    private var maxTotal by Delegates.notNull<Int>()

    val address: String
        get() = _address

    override fun update() {
        // configSource에서 address, timeout, maxTotal을 읽어온다
    }

    override fun outputInPlainText(): Unit = TODO("Not yet implemented")

    override fun output(): Map<String, String> = TODO("Not yet implemented")
}

class KafkaConfig(
    val configSource: ConfigSource
) : Config {
    override fun update(): Unit = TODO("Not yet implemented")
    override fun outputInPlainText(): Unit = TODO("Not yet implemented")
    override fun output(): Map<String, String> = TODO("Not yet implemented")
}

class MysqlConfig(
    val configSource: ConfigSource
) : Config {
    override fun update(): Unit = TODO("Not yet implemented")
    override fun outputInPlainText(): Unit = TODO("Not yet implemented")
    override fun output(): Map<String, String> = TODO("Not yet implemented")
}

class ScheduledUpdater(
    val config: Config,
    val initialDelayInSeconds: Long,
    val periodInSeconds: Long
) {
    private val executor = Executors.newSingleThreadExecutor() as ScheduledExecutorService

    fun run() {
        executor.scheduleAtFixedRate({
            Runnable(function = { config.update() })
        }, initialDelayInSeconds, periodInSeconds, TimeUnit.SECONDS)
    }
}

class SimpleHttpServer (
    val host: String,
    val port: Int
) {
    private val viewers: MutableMap<String, MutableList<Config>> = mutableMapOf()

    fun addViewer(urlDirectory: String, viewer: Config) {
        if (!viewers.containsKey(urlDirectory)) {
            viewers[urlDirectory] = mutableListOf()
        }

        viewers[urlDirectory]?.add(viewer)
    }

    fun run(): Unit = TODO()
}
