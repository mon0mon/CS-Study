package Ch06.Sec01.Part02.case_04

import java.util.concurrent.atomic.AtomicLong

// 홀더에 의한 초기화
class IdGenerator private constructor() {
    val id: Long
        get() = _id.incrementAndGet()
    private val _id = AtomicLong(0)

    companion object {
        val instance: IdGenerator
            get() {
                return InstanceHolder.instance
            }

        private class InstanceHolder {
            companion object {
                val instance = IdGenerator()
            }
        }
    }
}
