class EmailService_Old (
    private val toggleRouter: ToggleRouter
) {
    //region old
    fun generateInvoiceEmail(invoice: String): String {
        var baseEmail = buildEmailForInvoice(invoice)

        /**
         * 이메일 발송 코드에서 'next-gen-ecomm' 기능이 주문 취소 기능을 포함할 필요가 없음
         * 주문 취소 기능을 독립적으로 활성화하거나 비활성화 하는 등의 확장에서 문제 발생
         */
        return if (toggleRouter.featureIsEnabled("next-gen-ecomm")) {
            addOrderCancellationContentToEmail(baseEmail)
        } else {
            baseEmail
        }
    }
    //endregion

    private fun addOrderCancellationContentToEmail(invoice: String): String {
        return """
            $invoice
            append order status
        """.trimIndent()
    }

    private fun buildEmailForInvoice(invoice: String): String {
        return "email to $invoice"
    }
}

class EmailService_New (
    private val toggleRouter: ToggleRouter
) {
    private val featureDecision: FeatureDecisions = FeatureDecisions(toggleRouter)
    //region new
    fun generateInvoiceEmail(invoice: String): String {
        var baseEmail = buildEmailForInvoice(invoice)

        //  이메일 서비스에서는 어떤 기준으로 주문 취소 이메일이 활성화 되는지 알 필요가 없음
        return if (featureDecision.includeOrderCancellationInEmail()) {
            addOrderCancellationContentToEmail(baseEmail)
        } else {
            baseEmail
        }
    }
    //endregion

    private fun addOrderCancellationContentToEmail(invoice: String): String {
        return """
            $invoice
            append order status
        """.trimIndent()
    }

    private fun buildEmailForInvoice(invoice: String): String {
        return "email to $invoice"
    }
}

class FeatureDecisions(
    val toggleRouter: ToggleRouter
) {
    //  주문 취소 메일을 포함할 기능이나 특정 조건을 처리하도록 분리
    //  추후에 범위를 확장하거나 축소하는데 유리
    fun includeOrderCancellationInEmail(): Boolean {
        return toggleRouter.featureIsEnabled("next-gen-ecomm")
    }
    // ... 추가적인 기능 결정 함수들 ...
}
