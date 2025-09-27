package Ch04.Sec03.Part03.case_02

import java.time.OffsetDateTime

val transactions: List<Transaction> = listOf()

// 분할전 이전 함수
fun selectTransactions(
    userId: Long, startDate: OffsetDateTime? = null, endDate: OffsetDateTime? = null
): List<Transaction> {
    if (startDate != null && endDate != null) {
        // startDate와 endDate 사이의 데이터 처리
        return transactions.filter { transaction -> transaction.between(startDate, endDate) }
    } else if (startDate != null) {
        // startDate 이후의 모든 데이터 처리
        return transactions.filter { transaction -> transaction.startAfter(startDate) }
    } else if (endDate != null) {
        // endDate 이전의 모든 데이터 처리
        return transactions.filter { transaction -> transaction.endBefore(endDate) }
    } else {
        // 모든 데이터 처리
        return transactions
    }
}

// 여러개의 public 함수로 분할
fun selectTransactionsBetween(userId: Long, startDate: OffsetDateTime, endDate: OffsetDateTime) =
    selectTransactions(userId = userId, startDate = startDate, endDate = endDate)

fun selectTransactionsStartWith(userId: Long, startDate: OffsetDateTime) = selectTransactions(userId = userId,
    startDate = startDate)

fun selectTransactionsEndWith(userId: Long, endDate: OffsetDateTime) =
    selectTransactions(userId = userId, endDate = endDate)

fun selectAllTransactions(userId: Long) = selectTransactions(userId = userId)

data class Transaction(val userId: Long, val startedAt: OffsetDateTime, val endedAt: OffsetDateTime) {
    fun startAfter(given: OffsetDateTime): Boolean {
        return startedAt.isAfter(given)
    }

    fun endBefore(given: OffsetDateTime): Boolean {
        return endedAt.isBefore(given)
    }

    fun between(start: OffsetDateTime, end: OffsetDateTime): Boolean {
        return startedAt.isAfter(start) && endedAt.isBefore(end)
    }
}
