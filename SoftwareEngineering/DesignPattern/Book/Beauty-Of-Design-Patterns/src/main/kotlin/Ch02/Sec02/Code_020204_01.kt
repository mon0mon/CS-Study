package Ch02.Sec02

import com.sun.tools.javac.util.ArrayUtils.ensureCapacity

/**
 * 2.2.4 다형성
 *
 * p.g 35
 */
fun main() {
    val dynamicArray = SortedDynamicArray()

    dynamicArray.add(5)
    dynamicArray.add(1)
    dynamicArray.add(3)

    for (i in 0 .. 2) {
        println(dynamicArray[i])
    }
}

open class DynamicArray {
    protected var size = 0
    protected var capacity = DEFAULT_CAPACITY
    protected var elements = IntArray(capacity) { Int.MAX_VALUE }

    companion object {
        val DEFAULT_CAPACITY = 10
    }

    operator fun get(index: Int): Int = elements[index]

    open fun add(element: Int) {
        ensureCapacity()
        elements[size++] = element
    }

    protected fun ensureCapacity() {
        // 배열이 가득 찼을 때 배열의 크기를 확장하는 메소드
        if (size == capacity) {
            elements = elements.copyOf(capacity * 2)
            capacity *= 2
        }
    }
}

class SortedDynamicArray: DynamicArray() {
    override fun add(element: Int) {
        ensureCapacity()
        super.add(element)

       elements.sort()
    }
}
