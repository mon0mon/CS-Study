package Ch04.Sec03.Part05

fun calculateCircularArea(radius: Double): Double {
    return 3.1415 * radius * radius
}

// 매직 넘버 대신 상수 사용
const val PI: Double = 3.1415

fun calculateCircularArea2(radius: Double): Double {
    return PI * radius * radius
}
