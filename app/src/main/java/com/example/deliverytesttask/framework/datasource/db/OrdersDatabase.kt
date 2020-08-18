package com.example.deliverytesttask.framework.datasource.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.deliverytesttask.framework.datasource.db.entities.OrderEntity

@Database(entities = [OrderEntity::class], version = 1)
abstract class OrdersDatabase : RoomDatabase() {
    companion object {
        private const val DATABASE_NAME = "orders"

        private var instance: OrdersDatabase? = null

        private fun create(context: Context): OrdersDatabase = Room.databaseBuilder(context, OrdersDatabase::class.java, DATABASE_NAME).build()

        fun getInstance(context: Context): OrdersDatabase = (instance ?: create(context)).also { instance = it }
    }

    abstract fun ordersDAO(): OrdersDAO
}