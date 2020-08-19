package com.example.core.data

import com.example.core.domain.Order

interface LocalDataSource {

    suspend fun getMyOrders(): List<Order>

    suspend fun saveMyOrder(orders: List<Order>)
}