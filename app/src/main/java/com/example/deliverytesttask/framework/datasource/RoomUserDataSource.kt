package com.example.deliverytesttask.framework.datasource

import android.content.Context
import com.example.core.data.LocalDataSource
import com.example.core.domain.User
import com.example.deliverytesttask.framework.datasource.db.OrdersDatabase

class RoomUserDataSource(context: Context) : LocalDataSource {

    private val filmsDao = OrdersDatabase.getInstance(context).ordersDAO()

    override suspend fun getUserInfo(): User {
        TODO("Not yet implemented")
    }

    override suspend fun saveUserInfo(user: User) {
        TODO("Not yet implemented")
    }

}