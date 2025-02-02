data class InvoiceEmailerConfig(
    val includeOrderCancellationInEmail: Boolean
)

class FeatureAwareFactory(private val featureDecisions: FeatureDecisions) {

    fun clearFeatures() {
        featureDecisions.toggleRouter.clearAllFeatures()
    }

    fun invoiceEmailer(): InvoiceEmailer {
        val config = InvoiceEmailerConfig(
            includeOrderCancellationInEmail = featureDecisions.includeOrderCancellationInEmail()
        )
        return InvoiceEmailer(config)
    }

    // ... 다른 팩토리 메서드들 ...
}

class InvoiceEmailer(private val config: InvoiceEmailerConfig) {

    fun generateInvoiceEmail(invoice: String): String {
        val baseEmail = buildEmailForInvoice(invoice)
        return if (config.includeOrderCancellationInEmail) {
            addOrderCancellationContentToEmail(baseEmail)
        } else {
            baseEmail
        }
    }

    private fun buildEmailForInvoice(invoice: String): String {
        return "Email for invoice: $invoice"
    }

    private fun addOrderCancellationContentToEmail(email: String): String {
        return """
            $email
            Order cancellation content appended
        """.trimIndent()
    }
}
