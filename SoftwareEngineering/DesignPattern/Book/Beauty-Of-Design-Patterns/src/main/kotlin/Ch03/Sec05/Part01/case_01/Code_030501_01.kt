package Ch03.Sec05.Part01.case_01

fun main() {
    if (UserServiceTest.doTest()) {
        println("Test succeed.")
    } else {
        println("Test failed.")
    }
}

class UserServiceTest {

    companion object {
        fun doTest(): Boolean = TODO()
    }
}
