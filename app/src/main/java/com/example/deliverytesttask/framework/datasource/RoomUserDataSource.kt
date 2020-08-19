package com.example.deliverytesttask.framework.datasource

import android.content.Context
import com.example.core.data.LocalDataSource
import com.example.core.domain.Order
import com.example.core.domain.User
import com.example.deliverytesttask.framework.datasource.db.OrdersDatabase
import com.example.deliverytesttask.framework.datasource.db.entities.OrderEntity

class RoomUserDataSource(context: Context) : LocalDataSource {

    private val ordersDao = OrdersDatabase.getInstance(context).ordersDAO()

    override suspend fun getMyOrders(): List<Order> {
        return ordersDao.getMyOrders().map {
            Order(
                it.id,
                it.locationFrom,
                it.dateFrom,
                it.locationTo,
                it.dateTo,
                it.cost
            )
        }
    }

    override suspend fun saveMyOrder(orders: List<Order>) {
        ordersDao.insertOrders(orders.map {
            OrderEntity(
                ordersDao.getMyOrders().size,
                it.locationFrom,
                it.dateFrom,
                it.locationTo,
                it.dateTo,
                it.cost
            )
        })
    }

}