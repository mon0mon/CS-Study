package Ch06.Sec01.Part02.case_05

import java.util.concurrent.atomic.AtomicLong

// 열거형 기반 방식
enum class IdGenerator {
    INSTANCE;

    val id: Long
        get() = _id.incrementAndGet()
    private val _id = AtomicLong(0)
}
