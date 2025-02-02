/**
 * Making a flag dynamic
 */

class ToggleRouter(
    private val features: MutableMap<String, Boolean> = mutableMapOf()
) {
    fun addFeature(featureName: String, featureValue: Boolean): ToggleRouter {
        features[featureName] = featureValue
        return this
    }

    fun featureIsEnabled(featureName: String): Boolean {
        return features.getOrDefault(featureName, false)
    }

    fun clearAllFeatures() {
        features.clear()
    }
}

class SimulationEngine(
    val toggleRouter: ToggleRouter
) {
    fun reticulateSplines(featureName: String): String {
        return if (toggleRouter.featureIsEnabled(featureName)) {
            enhancedSplineReticulation()
        } else {
            oldFashionedSplineReticulation()
        }
    }
}
