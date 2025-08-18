package Ch03.Sec03.case_02

fun main() {
    val transporter = SecurityTransporter("myAppId", "myAppToken", HttpClient())
    val request = Request()
    val response = transporter.sendRequest(request)
}

open class Transporter(
    protected open val httpClient: HttpClient
) {

    open fun sendRequest(request: Request): Response {
        // httpClient를 통해 발송 요청하는 코드 생략
        TODO()
    }
}

class SecurityTransporter(
    private val appId: String,
    private val appToken: String,
    override val httpClient: HttpClient
): Transporter(httpClient) {

    override fun sendRequest(request: Request): Response {
        if (appId.isBlank() && appToken.isBlank()) {
            throw NoAuthorizationRuntimeException()
        }

        request.addPayload("appId", appId)
        request.addPayload("appToken", appToken)

        return super.sendRequest(request)
    }
}

class HttpClient

class Request {
    fun addPayload(name: String, value: String) {}
}

class Response

class NoAuthorizationRuntimeException: RuntimeException()
