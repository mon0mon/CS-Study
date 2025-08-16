package Ch02.Sec02

import kotlin.Array

/**
 * 2.2.4 다형성
 *
 * p.g 37
 */
fun main() {
    val arrayIterator = Ch02.Sec02.Array()
    println(arrayIterator)

    val linkedListIterator = Ch02.Sec02.LinkedList()
    println(linkedListIterator)
}

interface Iterator {
    fun hasNext(): Boolean
    fun next(): String
    fun remove(): String
}

class Array: Iterator {
    private var data: Array<String> = emptyArray<String>()

    override fun hasNext(): Boolean = false
    override fun next(): String = ""
    override fun remove(): String = ""
}

class LinkedList: Iterator {
    private var head: LinkedListNode = LinkedListNode()

    override fun hasNext(): Boolean = false
    override fun next(): String = ""
    override fun remove(): String = ""
}

private class LinkedListNode
