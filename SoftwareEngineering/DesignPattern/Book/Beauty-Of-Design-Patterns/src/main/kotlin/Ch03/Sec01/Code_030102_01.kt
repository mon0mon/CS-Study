package Ch03.Sec01

private class UserInfo(
    private val userId: Long,
    private val username: String,
    private val email: String,
    private val telephone: String,
    private val createTime: Long,
    private val lastLoginTime: Long,
    private val avatarUrl: String,
    // 도
    private val provinceOfAddress: String,
    // 시
    private val cityOfAddress: String,
    // 구
    private val regionOfAddress: String,
    // 상세 주소
    private val detailedAddress: String
)
