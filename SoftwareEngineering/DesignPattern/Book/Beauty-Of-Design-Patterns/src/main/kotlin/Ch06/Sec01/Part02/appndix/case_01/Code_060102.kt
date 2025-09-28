package Ch06.Sec01.Part02.appndix.case_01

import java.util.concurrent.atomic.AtomicLong

// 늦은 초기화 방식 구현
class IdGenerator private constructor() {
    val id: Long
        get() = _id.incrementAndGet()
    private val _id = AtomicLong(0)

    companion object {
        /**
         * 사용 시점 시, 객체 생성
         *   - LazyThreadSafetyMode로 동기화 레벨 설정 가능 (기본 값 SYNCHRONIZED)
         * 코틀린에서 직접 제공해주는 이중 잠금 매커니즘
         *
         * [Kotlin Docs](https://kotlinlang.org/docs/delegated-properties.html#lazy-properties)
         * @see LazyThreadSafetyMode
         */
        val instance: IdGenerator by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { IdGenerator() }
    }
}
