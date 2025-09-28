package Ch06.Sec01.Part02.case_03

import java.util.concurrent.atomic.AtomicLong

// 늦은 초기화 방식 구현 (이중 잠금)
class IdGenerator private constructor() {
    val id: Long
        get() = _id.incrementAndGet()
    private val _id = AtomicLong(0)

    companion object {
        @Volatile
        private var _instance: IdGenerator? = null

        val instance: IdGenerator
            get() {
                if (_instance == null) {
                    // 클래스 레벨의 잠금 처리
                    synchronized(IdGenerator::class) {
                        if (_instance == null)
                            _instance = IdGenerator()
                    }
                }

                return _instance!!
            }
    }
}
