package Ch03.Sec04.Part01.case_02

import Ch03.Sec04.Part01.case_01.UserInfo

interface UserService {
    fun register(cellPhone: String, password: String): Boolean
    fun login(cellphone: String, password: String): Boolean
    fun getUserInfoById(id: Long): UserInfo
    fun getUserInfoByCellPhone(cellphone: String): UserInfo
}

interface RestrictedUserService {
    fun deleteUserByCellPhone(cellPhone: String): Boolean
    fun deleteUserById(id: Long): Boolean
}

class UserServiceImpl: UserService, RestrictedUserService {
    override fun register(cellPhone: String, password: String): Boolean = TODO("Not yet implemented")

    override fun login(cellphone: String, password: String): Boolean = TODO("Not yet implemented")

    override fun getUserInfoById(id: Long): UserInfo = TODO("Not yet implemented")

    override fun getUserInfoByCellPhone(cellphone: String): UserInfo = TODO("Not yet implemented")

    override fun deleteUserByCellPhone(cellPhone: String): Boolean = TODO("Not yet implemented")

    override fun deleteUserById(id: Long): Boolean = TODO("Not yet implemented")
}
