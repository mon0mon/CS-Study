package Ch02.Sec03

interface ApiAuthenticator {
    fun auth(url: String)
    fun auth(apiRequest: ApiRequest)
}

class DefaultApiAuthenticator(
    private val credentialStorage: CredentialStorage = MysqlCredentialStorage()
) : ApiAuthenticator {
    override fun auth(url: String) {
        val apiRequest = ApiRequest.buildFromUrl(url)
        auth(apiRequest)
    }

    override fun auth(apiRequest: ApiRequest) {
        val appId = apiRequest.appId
        val token = apiRequest.token
        val timestamp = apiRequest.timestamp
        val originalUrl = apiRequest.originalUrl
        val clientAuthToken = AuthToken(token, timestamp)

        if (clientAuthToken.isExpired()) throw RuntimeException("Token is expired.")

        val password = credentialStorage.getPasswordByAppId(appId) ?: throw RuntimeException("Invalid appId.")
        val serverAuthToken = AuthToken.generate(originalUrl, appId, password, timestamp)

        if (!serverAuthToken.match(clientAuthToken)) throw RuntimeException("Token verification failed.")
    }
}

interface CredentialStorage {
    fun getPasswordByAppId(appId: String): String?
}

class MysqlCredentialStorage : CredentialStorage {
    override fun getPasswordByAppId(appId: String): String? = TODO()
}

data class ApiRequest(
    val appId: String = "",
    val token: String = "",
    val timestamp: Long = 0L,
    val originalUrl: String = ""
) {
    companion object {
        fun buildFromUrl(url: String) = ApiRequest(originalUrl = url)
    }
}

data class AuthToken(
    val token: String,
    val createTime: Long,
    val expiredTimeInterval: Long = 0L
) {
    companion object {
        fun generate(originalUrl: String, appId: String, password: String, timestamp: Long) = AuthToken(
            token = "",
            createTime = 0L,
            expiredTimeInterval = 0L
        )
    }

    fun isExpired(): Boolean = (System.currentTimeMillis() - createTime) > expiredTimeInterval
    fun match(clientAuthToken: AuthToken): Boolean = token == clientAuthToken.token
}
