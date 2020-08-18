package com.example.deliverytesttask.framework.datasource

import com.example.deliverytesttask.framework.datasource.retrofit.API
import com.example.core.data.RemoteDataSource
import com.example.core.domain.User

class ApiUserDataSource : RemoteDataSource {
    val api = API.getAPI()

    private lateinit var userInfo : User

    override suspend fun getUserInfo(): User {
        api.getUserInfo("lo2EC3eWZjn1kkHHS3CB","0F8JIqi4zwvb77FGz6Wt").execute().body()?.let {
            userInfo = it
        }
        return userInfo
    }
}