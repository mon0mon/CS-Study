package Ch02.Sec07

interface Filter {
    fun doFilter(req: RpcRequest)
}

// 인터페이스 구현: 인증 필터
class AuthenticationFilter : Filter {
    override fun doFilter(req: RpcRequest) {
        TODO("Not yet implemented")
    }
}

// 인터페이스 구현: 사용 제한 필터
class RateLimitFilter : Filter {
    override fun doFilter(req: RpcRequest) {
        TODO("Not yet implemented")
    }
}

// 필터 사용 예시
class Application(
    private val filters: List<Filter> = listOf(AuthenticationFilter(), RateLimitFilter())
) {
    fun handleRpcRequest(req: RpcRequest) {
        try {
            for (filter in filters) {
                filter.doFilter(req)
            }
        } catch (e: Exception) {
            println("Exception caught and handled.")
        }
    }
}

class RpcRequest
