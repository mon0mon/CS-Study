package Ch06.Sec01.Part02.case_02

import java.util.concurrent.atomic.AtomicLong

// 늦은 초기화 방식 구현
class IdGenerator private constructor() {
    val id: Long
        get() = _id.incrementAndGet()
    private val _id = AtomicLong(0)

    companion object {
        // 사용 시점 시, 객체 생성
        // 사용 직전 초기화가 이루어질 경우, 초기화 작업으로 인한 대기시간이 증가될 수 있음
        // synchronized 키워드로 인해, 동시성이 1로 변경되기 때문에, 병목 가능성이 높아짐
        private var _instance: IdGenerator? = null

        @Synchronized
        fun getInstance(): IdGenerator {
            if (_instance == null) {
                _instance = IdGenerator()
            }

            return _instance!!
        }
    }
}
