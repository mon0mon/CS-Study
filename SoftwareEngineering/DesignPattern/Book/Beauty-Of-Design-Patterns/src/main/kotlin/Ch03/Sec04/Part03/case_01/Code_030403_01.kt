package Ch03.Sec04.Part03.case_01

import kotlin.properties.Delegates

class RedisConfig (
    val configSource: ConfigSource
) {
    lateinit var _address: String
    private var timeout by Delegates.notNull<Int>()
    private var maxTotal by Delegates.notNull<Int>()

    val address: String
        get() = _address

    fun update() {
        // configSource에서 address, timeout, maxTotal을 읽어온다
    }
}

class ConfigSource

// 구현 생략
class KafkaConfig

// 구현 생략
class MysqlConfig
