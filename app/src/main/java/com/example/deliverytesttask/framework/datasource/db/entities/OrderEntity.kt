package com.example.deliverytesttask.framework.datasource.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.domain.Location

@Entity
data class OrderEntity(
    @PrimaryKey
    val id: Int,
    val locationFrom: String,
    val dateFrom: String,
    val locationTo: String,
    val dateTo: String,
    val cost: String
)