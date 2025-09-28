package Ch06.Sec01.Part02.appndix.case_02

import java.util.concurrent.atomic.AtomicLong

/**
 * 빠른 초기화 방식
 *
 * [Kotlin Docs](https://kotlinlang.org/docs/object-declarations.html)
 */
object IdGenerator {
    val id: Long
        get() = _id.incrementAndGet()
    private val _id = AtomicLong(0)
}
