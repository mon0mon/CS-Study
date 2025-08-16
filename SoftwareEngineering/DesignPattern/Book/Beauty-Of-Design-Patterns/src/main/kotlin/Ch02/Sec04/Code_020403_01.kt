package Ch02.Sec04

import java.util.stream.Stream

fun main() {
    val result = Stream.of("foo", "ba", "hello")
        .map(String::length)
        .filter { it <= 3 }
        .max(Comparator.naturalOrder())
        .get()

    println(result)
}
