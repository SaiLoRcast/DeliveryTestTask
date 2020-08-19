package com.example.core.data

import com.example.core.domain.User
import com.example.core.domain.UsersData

interface RemoteDataSource {
    suspend fun getUserInfo(): User
    suspend fun getUsersList(): UsersData
}