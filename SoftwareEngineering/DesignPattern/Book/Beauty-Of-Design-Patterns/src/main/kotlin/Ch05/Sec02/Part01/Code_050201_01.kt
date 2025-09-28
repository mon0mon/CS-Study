package Ch05.Sec02.Part01

data class Text(
    val content: String?
) {

    /**
     * 문자열을 숫자로 변환하며, 문자열의 앞뒤 공백은 잘라낸다.
     * 문자열에 숫자가 아닌 문자가 포함된 경우 null을 반환한다.
     */
    fun toNumber(): Int? {
        if (content == null || content.isBlank()) {
            return null
        }

        return try {
            content.trim().toInt()
        } catch (e: Exception) {
            null
        }
    }
}
