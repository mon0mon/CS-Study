package Ch05.Sec02.Part01

private const val TEST_SUCCEEDED_MSG = "Test succeeded"

fun main() {
    val test = TextTest()

    println("Run testToNumber()")
    test.testToNumber()

    println("Run testToNumber_nullOrEmpty()")
    test.testToNumber_nullOrEmpty()

    println("Run testToNumber_containsLeadingAndTrailingSpaces()")
    test.testToNumber_containsLeadingAndTrailingSpaces()

    println("Run testToNumber_containsMultiLeadingAndTrailingSpaces()")
    test.testToNumber_containsLeadingAndTrailingSpaces()

    println("Run testToNumber_containsInvalidCharacters()")
    test.testToNumber_containsInvalidCharacters()
}

class Assert {
    companion object {
        fun assertEquals(expectedValue: Int?, actualValue: Int?) {
            if (actualValue != expectedValue) {
                println(String.format("Test failed, expected %d but was %d", expectedValue, actualValue))
            } else {
                println(TEST_SUCCEEDED_MSG)
            }
        }

        fun assertNull(actualValue: Int?): Boolean {
            val isNull = actualValue == null

            if (isNull) {
                println(TEST_SUCCEEDED_MSG)
            } else {
                println(String.format("Test failed, expected null but was %d", actualValue))
            }

            return isNull
        }
    }
}

class TextTest {
    fun testToNumber() {
        val text = Text("123")

        Assert.assertEquals(123, text.toNumber())
    }

    fun testToNumber_nullOrEmpty() {
        val text = Text(null)
        Assert.assertNull(text.toNumber())

        val text2 = Text("")
        Assert.assertNull(text2.toNumber())
    }

    fun testToNumber_containsLeadingAndTrailingSpaces() {
        val text = Text(" 123")
        Assert.assertEquals(123, text.toNumber())

        val text2 = Text("123 ")
        Assert.assertEquals(123, text2.toNumber())

        val text3 = Text(" 123 ")
        Assert.assertEquals(123, text3.toNumber())
    }

    fun textToNumber_containsMultiLeadingAndTrailingSpaces() {
        val text = Text(" 123")
        Assert.assertEquals(123, text.toNumber())

        val text2 = Text("123 ")
        Assert.assertEquals(123, text2.toNumber())

        val text3 = Text(" 123 ")
        Assert.assertEquals(123, text3.toNumber())
    }

    fun testToNumber_containsInvalidCharacters() {
        val text = Text("123a4")
        Assert.assertNull(text.toNumber())

        val text2 = Text("123 4")
        Assert.assertNull(text2.toNumber())
    }
}
