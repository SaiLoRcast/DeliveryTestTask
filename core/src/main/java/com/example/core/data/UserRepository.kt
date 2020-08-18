package com.example.core.data


import com.example.core.domain.User

class UserRepository(
    private val localDataSource: LocalDataSource,
    private val webDataSource: RemoteDataSource? = null
) {
    private lateinit var userInfo: User

    private suspend fun loadUserInfo() {
//        if (userInfo.isEmpty()) {//it might be already cached
//        userInfo = localDataSource.getUserInfo()
        if (webDataSource != null) {//if there is nothing in DB then load from server, if server is available
            userInfo = webDataSource.getUserInfo()
//            localDataSource.saveUserInfo(userInfo)
        }
//        }
    }

    suspend fun getUserInfo(): User {
        loadUserInfo()

        return userInfo
    }

}