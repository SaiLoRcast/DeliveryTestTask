package com.example.core.data

import com.example.core.domain.Order
import com.example.core.domain.User
import com.example.core.domain.UsersData

class UserRepository(
    private val localDataSource: LocalDataSource,
    private val webDataSource: RemoteDataSource? = null
) {
    private lateinit var userInfo: User
    private lateinit var userLocation: User
    private lateinit var usersList: UsersData
    private var myOrdersList = listOf<Order>()

    private suspend fun loadUserInfo() {
        if (webDataSource != null) {
            userInfo = webDataSource.getUserInfo()
        }
    }

    private suspend fun loadUserLocation() {
        if (webDataSource != null) {
            userLocation = webDataSource.getUserLocation()
        }
    }

    private suspend fun loadUsersList() {
        if (webDataSource != null) {
            usersList = webDataSource.getUsersList()
        }
    }

    private suspend fun loadMyOrdersList() {
        if (myOrdersList.isEmpty()) {
            myOrdersList = localDataSource.getMyOrders()
        }
    }

    suspend fun getUserInfo(): User {
        loadUserInfo()
        return userInfo
    }

    suspend fun getUserLocation(): User {
        loadUserLocation()
        return userLocation
    }

    suspend fun getUsersList(): UsersData {
        loadUsersList()
        return usersList
    }

    suspend fun getMyOrders(): List<Order> {
        loadMyOrdersList()
        return myOrdersList
    }

}