package Ch05.Sec05.Part04

import java.net.InetAddress
import kotlin.random.Random

interface IdGenerator {
    fun generate(): String
}

object LogTraceIdGenerator : IdGenerator {

    /**
     * ID 생성기로 만들어진 ID
     *
     * 101-1758969495122-JAAV2lFb
     * 101-1758969495134-CchoBWmx
     * 101-1758969495144-CNFbKtaD
     */
    override fun generate(): String {
        val hostName = getLastFieldOfHostName()
        val currentTimeMillis = System.currentTimeMillis()
        val randomString = generateRandomAlphanumeric(8)
        val id = String.format("%s-%d-%s", hostName, currentTimeMillis, randomString)

        return id
    }

    private fun getLastFieldOfHostName(): String? {
        var substrOfHostName: String? = null

        try {
            val hostName = InetAddress.getLocalHost().hostName
            val tokens = hostName.split("\\.")

            substrOfHostName = tokens[tokens.size - 1]
        } catch (e: Exception) {
            System.err.println(e)
        }

        return substrOfHostName
    }

    private fun generateRandomAlphanumeric(length: Int): String {
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
