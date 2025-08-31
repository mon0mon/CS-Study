package Ch03.Sec06.case_02

// KMP 계산: a, b는 기본 문자열과 패턴 문자열이며, n, m은 각각의 길이이다
fun kmp(a: CharArray, n: Int, b: CharArray, m: Int): Int {
    val next = getNexts(b, m)

    var j = 0
    for (i in 0..n) {
        while (j > 0 && a[i] != b[j]) {
            j = next[j - 1] + 1
        }

        if (a[i] == b[j]) {
            ++j
        }

        if (j == m) {
            return i - m + 1
        }
    }

    return -1
}

fun getNexts(b: CharArray, m: Int): IntArray {
    val next = IntArray(m)

    next[0] = -1

    var k = -1
    for (i in 1..m) {
        while (k != -1 && b[k + 1] != b[i]) {
            k = next[k]
        }

        if (b[k + 1] == b[i]) {
            ++k
        }

        next[i] = k
    }

    return next
}
