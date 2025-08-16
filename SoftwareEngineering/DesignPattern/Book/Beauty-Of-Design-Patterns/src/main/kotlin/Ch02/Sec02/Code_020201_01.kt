package Ch02.Sec02

import java.math.BigDecimal

/**
 * 2.2.1 캡슐화
 *
 * p.g 28
 */
fun main() {
    val wallet = Wallet()
    println("Initial balance: ${wallet.balance}")
    wallet.increaseBalance(BigDecimal(100))
    println("After increase balance: ${wallet.balance}")
    wallet.decreaseBalance(BigDecimal(50))
    println("After decrease balance: ${wallet.balance}")
}

private class Wallet (
    val id: String = IdGenerator.instance.generate(),
    val createTime: Long = System.currentTimeMillis(),
    var balanceLastModifiedTime: Long = System.currentTimeMillis(),
    // 내부적으로 변경 가능한 mutable 필드
    // 외부에는 노출되지 않음
    private var _balance: BigDecimal = BigDecimal.ZERO
) {
    //  Backing Field를 사용해서, 외부에서는 Immutable하고, 내부에서는 mutable한 의도를 표현
    //  balance는 외부로 setter를 노출하지 않음 (Readonly property)
    val balance: BigDecimal
        get() = _balance

    fun increaseBalance(increasedAmount: BigDecimal) {
        checkAmountGreaterThenZero(increasedAmount)

        _balance += increasedAmount
        balanceLastModifiedTime = System.currentTimeMillis()
    }

    fun decreaseBalance(decreasedAmount: BigDecimal) {
        checkAmountGreaterThenZero(decreasedAmount)

        _balance -= decreasedAmount
        balanceLastModifiedTime = System.currentTimeMillis()
    }

    private fun checkAmountGreaterThenZero(amount: BigDecimal) {
        if (amount < BigDecimal.ZERO) {
            throw IllegalArgumentException()
        }
    }
}


private class IdGenerator {
    companion object {
        val instance = IdGenerator()
    }

    fun generate(): String = "id" + System.currentTimeMillis()
}
