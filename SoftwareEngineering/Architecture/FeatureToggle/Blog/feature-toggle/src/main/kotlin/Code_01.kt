/**
 * The birth of a Feature Flag
 */

//region before
fun reticulateSplines_Old() {
    //  current implementation lives here
}
//endregion

//region after
fun reticulateSplines_New(): String {
    var useNewAlgorithm = false;
    // useNewAlgorithm = true; // UNCOMMENT IF YOU ARE WORKING ON THE NEW SR ALGORITHM

    if (useNewAlgorithm) {
        return enhancedSplineReticulation();
    } else {
        return oldFashionedSplineReticulation();
    }
}

fun oldFashionedSplineReticulation(): String {
    // current implementation lives here
    return "oldFashionedSplineReticulation"
}

fun enhancedSplineReticulation(): String {
    // TODO: implement better SR algorithm
    return "enhancedSplineReticulation"
}
//endregion
