package Ch03.Sec04.Part01.case_01

interface UserService {
    fun register(cellPhone: String, password: String): Boolean
    fun login(cellphone: String, password: String): Boolean
    fun getUserInfoById(id: Long): UserInfo
    fun getUserInfoByCellPhone(cellphone: String): UserInfo
}

class UserServiceImpl : UserService {

    override fun register(cellPhone: String, password: String): Boolean = TODO("Not yet implemented")

    override fun login(cellphone: String, password: String): Boolean = TODO("Not yet implemented")

    override fun getUserInfoById(id: Long): UserInfo = TODO("Not yet implemented")

    override fun getUserInfoByCellPhone(cellphone: String): UserInfo = TODO("Not yet implemented")
}

class UserInfo
