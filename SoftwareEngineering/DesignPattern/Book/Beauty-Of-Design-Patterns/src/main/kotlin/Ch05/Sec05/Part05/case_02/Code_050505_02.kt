package Ch05.Sec05.Part05.case_02

import org.jetbrains.annotations.TestOnly
import java.net.InetAddress
import java.net.UnknownHostException
import kotlin.random.Random

interface IdGenerator {
    fun generate(): String
}

class LogTraceIdGenerator : IdGenerator {

    /**
     * ID 생성기로 만들어진 ID
     *
     * 101-1758969495122-JAAV2lFb
     * 101-1758969495134-CchoBWmx
     * 101-1758969495144-CNFbKtaD
     */
    override fun generate(): String {
        val hostName: String = try { getLastFieldOfHostName() }
            catch (e: UnknownHostException) { throw RuntimeException("host name is not valid") }
        val currentTimeMillis = System.currentTimeMillis()
        val randomString = generateRandomAlphanumeric(8)
        val id = String.format("%s-%d-%s", hostName, currentTimeMillis, randomString)

        return id
    }

    private fun getLastFieldOfHostName(): String {
        val hostName = InetAddress.getLocalHost().hostName

        if (hostName.isBlank()) throw UnknownHostException()

        return getLastSubstrSplitByDot(hostName)
    }

    @TestOnly
    private fun getLastSubstrSplitByDot(hostName: String): String {
        if (hostName.isBlank()) throw IllegalArgumentException("host name is blank")

        val tokens = hostName.split("\\.")

        return tokens[tokens.size - 1]
    }

    @TestOnly
    private fun generateRandomAlphanumeric(length: Int): String {
        if (length < 1) throw IllegalArgumentException("length must be greater than 0")

        val randomChars = CharArray(length)
        var count = 0

        while (count < length) {
            val maxAscii = 'z'
            val randomAscii = Random.nextInt(maxAscii.digitToInt())

            val isDigit = randomAscii in '0'.code..'9'.code
            val isUppercase = randomAscii in 'A'.code..'Z'.code
            val isLowercase = randomAscii in 'a'.code..'z'.code

            if (isDigit || isUppercase || isLowercase) {
                randomChars[count]  = randomAscii.toChar()
                count++
            }
        }

        return String(randomChars)
    }
}
