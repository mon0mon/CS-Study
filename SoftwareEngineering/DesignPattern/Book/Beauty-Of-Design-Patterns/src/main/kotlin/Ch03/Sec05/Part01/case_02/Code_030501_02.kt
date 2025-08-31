package Ch03.Sec05.Part01.case_02

fun main() {
    val application = JunitApplication()

    application.register(UserServiceTest())

    application.run()
}

abstract class TestCase {

    fun run() {
        if (doTest()) {
            println("Test succeed.")
        } else {
            println("Test failed.")
        }
    }

    abstract fun doTest(): Boolean
}

class UserServiceTest: TestCase() {

    override fun doTest(): Boolean = TODO("Not yet implemented")
}

class JunitApplication {
    private val testCases = mutableListOf<TestCase>()

    fun register(testCase: TestCase) {
        testCases.add(testCase)
    }

    fun run() {
        for (case in testCases) {
            case.run()
        }
    }
}
