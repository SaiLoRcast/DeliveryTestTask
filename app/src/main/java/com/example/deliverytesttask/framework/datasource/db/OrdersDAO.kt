package com.example.deliverytesttask.framework.datasource.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.deliverytesttask.framework.datasource.db.entities.OrderEntity

@Dao
interface OrdersDAO {
    @Insert
    fun insertOrders(orders: List<OrderEntity>)

    @Query("SELECT * FROM orderentity")
    fun getMyOrders() : List<OrderEntity>
}