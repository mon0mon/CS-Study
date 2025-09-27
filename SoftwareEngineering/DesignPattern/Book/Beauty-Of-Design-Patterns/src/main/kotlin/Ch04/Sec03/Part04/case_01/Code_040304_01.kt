package Ch04.Sec03.Part04.case_01

// 첫 번째 예제
fun calculateTotalAmount(orders: List<Order>): Double {
    if (orders.isEmpty()) {
        return 0.0
    } else {
        // if 내부에서 return을 사용하면 이 else 문을 없앨 수 있다
        var amount = 0.0

        for (order in orders) {
            amount += order.totalPrice
        }

        return amount
    }
}

// 리팩토링 후
fun calculateTotalAmount2(orders: List<Order>): Double {
    if (orders.isEmpty()) return 0.0

    // 함수형 프로그래밍 및 data class 내부의 함수를 사용하여 간결하게 리팩토링
    return orders.sumOf { it.totalPrice }
}

data class Order(val count: Int, val price: Double) {
    val totalPrice: Double = count * price
}
