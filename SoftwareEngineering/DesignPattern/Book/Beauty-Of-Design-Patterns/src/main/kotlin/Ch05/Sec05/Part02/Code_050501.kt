package Ch05.Sec05.Part02

import java.net.InetAddress
import kotlin.random.Random

object IdGenerator {

    /**
     * ID 생성기로 만들어진 ID
     *
     * 101-1758969495122-JAAV2lFb
     * 101-1758969495134-CchoBWmx
     * 101-1758969495144-CNFbKtaD
     */
    fun generate(): String {
        var id = ""

        try {
            var hostName = InetAddress.getLocalHost().hostName
            val tokens = hostName.split("\\.")

            if (tokens.size > 0) {
                hostName = tokens[tokens.size - 1]
            }

            val randomChars = CharArray(8)
            var count = 0

            while (count < 8) {
                var randomAscii = Random.nextInt(122)

                if (randomAscii >= 48 && randomAscii <= 57) {
                    randomChars[count] = '0' + (randomAscii - 48)
                    count++
                } else if (randomAscii >= 65 && randomAscii <= 90) {
                    randomChars[count] = 'A' + (randomAscii - 65)
                    count++
                } else if (randomAscii >= 97 && randomAscii <= 122) {
                    randomChars[count] = 'a' + (randomAscii - 97)
                    count++
                }
            }

            id = String.format("%s-%d-%s", hostName, System.currentTimeMillis(), String(randomChars))
        } catch (e: Exception) {
            System.err.println(e)
        }

        return id
    }
}
