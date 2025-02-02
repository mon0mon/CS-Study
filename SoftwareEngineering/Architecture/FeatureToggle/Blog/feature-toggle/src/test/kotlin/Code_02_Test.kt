import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

private const val FEATURE_NAME = "use-new-SR-algorithm"
private const val FEATURE_VALUE = true
private const val OLD_FASHIONED_SPLINE_RETICULATION = "oldFashionedSplineReticulation"
private const val ENHANCED_SPLINE_RETICULATION = "enhancedSplineReticulation"

class Code_02_Test {
    private var toggleRouter: ToggleRouter = ToggleRouter()
    private var simulationEngine: SimulationEngine = SimulationEngine(toggleRouter)

    @BeforeEach
    fun beforeEach() {
        toggleRouter.clearAllFeatures()
        toggleRouter.addFeature(FEATURE_NAME, FEATURE_VALUE)
        simulationEngine = SimulationEngine(toggleRouter)
    }

    @Test
    fun `토글 라우터에서 값이 설정 되지 않았을 때 - 기존 코드 실행`() {
        //  Given
        toggleRouter.clearAllFeatures()

        //  When
        val actual = simulationEngine.reticulateSplines(FEATURE_NAME)

        //  Then
        Assertions.assertEquals(OLD_FASHIONED_SPLINE_RETICULATION, actual)
        Assertions.assertNotEquals(ENHANCED_SPLINE_RETICULATION, actual)
    }

    @Test
    fun `토글 라우터에서 값이 설정 되었을 때 - 신규 코드 실행`() {
        //  Given

        //  When
        val actual = simulationEngine.reticulateSplines(FEATURE_NAME)

        //  Then
        Assertions.assertEquals(ENHANCED_SPLINE_RETICULATION, actual)
        Assertions.assertNotEquals(OLD_FASHIONED_SPLINE_RETICULATION, actual)
    }
}
