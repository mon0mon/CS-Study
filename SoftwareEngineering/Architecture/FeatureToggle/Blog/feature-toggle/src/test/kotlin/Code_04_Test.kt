import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

private const val CANCELLATION_EMAIL_FEATURE_NAME = "next-gen-ecomm"
private const val BASE_EMAIL_RESULT = "Email for invoice: mon0mon"
private val CANCELLATION_EMAIL_RESULT = """
    Email for invoice: mon0mon
    Order cancellation content appended
""".trimIndent()

class Code_04_Test {
    private lateinit var featureAwareFactory: FeatureAwareFactory
    private val features: MutableMap<String, Boolean> = mutableMapOf(Pair(CANCELLATION_EMAIL_FEATURE_NAME, true))

    @BeforeEach
    fun beforeEach() {
        val featureDecisions = FeatureDecisions(ToggleRouter(features))
        featureAwareFactory = FeatureAwareFactory(featureDecisions)
    }

    @Test
    fun `next-gen-ecomm이 활성화 되었을 경우`() {
        //  given
        val emailer = featureAwareFactory.invoiceEmailer()

        //  when
        val actual = emailer.generateInvoiceEmail("mon0mon")

        //  then
        Assertions.assertEquals(CANCELLATION_EMAIL_RESULT, actual)
        Assertions.assertNotEquals(BASE_EMAIL_RESULT, actual)
    }

    @Test
    fun `next-gen-ecomm이 비활성화 되었을 경우`() {
        //  given
        featureAwareFactory.clearFeatures()
        val emailer = featureAwareFactory.invoiceEmailer()

        //  when
        val actual = emailer.generateInvoiceEmail("mon0mon")

        //  then
        Assertions.assertEquals(BASE_EMAIL_RESULT, actual)
        Assertions.assertNotEquals(CANCELLATION_EMAIL_RESULT, actual)
    }
}
