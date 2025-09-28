package Ch06.Sec01.Part02.case_01

import java.util.concurrent.atomic.AtomicLong

// 즉시 초기화 방식 구현
class IdGenerator private constructor() {
    val id: Long
        get() = _id.incrementAndGet()
    private val _id = AtomicLong(0)

    companion object {
        // 사용 시점이 아닌, 미리 생성됨
        val instance = IdGenerator()
    }
}
