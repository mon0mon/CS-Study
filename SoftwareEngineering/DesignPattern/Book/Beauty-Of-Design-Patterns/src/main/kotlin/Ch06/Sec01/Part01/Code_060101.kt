package Ch06.Sec01.Part01

import java.util.concurrent.atomic.AtomicLong

class IdGenerator {
    val id: Long
        get() = _id.incrementAndGet()
    private val _id = AtomicLong(0)

    companion object {
        val instance = IdGenerator()
    }
}
