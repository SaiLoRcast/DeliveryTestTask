package com.example.core.data

import com.example.core.domain.User

interface RemoteDataSource {
    suspend fun getUserInfo(): User
}