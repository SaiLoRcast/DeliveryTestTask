package com.example.core.data

import com.example.core.domain.User

interface LocalDataSource {

    suspend fun getUserInfo(): User
    suspend fun saveUserInfo(user: User)
}