package com.example.deliverytesttask.framework.datasource

import com.example.deliverytesttask.framework.datasource.retrofit.API
import com.example.core.data.RemoteDataSource
import com.example.core.domain.User
import com.example.core.domain.UsersData

class ApiUserDataSource : RemoteDataSource {
    private val api = API.getAPI()

    private lateinit var userInfo : User
    private lateinit var userLocation : User
    private lateinit var usersData: UsersData

    override suspend fun getUserInfo(): User {
        api.getUserInfo("lo2EC3eWZjn1kkHHS3CB","0F8JIqi4zwvb77FGz6Wt").execute().body()?.let {
            userInfo = it
        }
        return userInfo
    }

    override suspend fun getUserLocation(): User {
        api.getUserInfo("lo2EC3eWZjn1kkHHS3CB","0P6E1d4nr0L1ntW8cjGU").execute().body()?.let {
            userLocation = it
        }
        return userLocation
    }

    override suspend fun getUsersList(): UsersData {
        api.getUsersList("lo2EC3eWZjn1kkHHS3CB").execute().body()?.let {
            usersData = it
        }
        return usersData
    }
}