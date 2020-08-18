package com.example.deliverytesttask.framework.datasource.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.domain.Location

@Entity
data class OrderEntity(
    @PrimaryKey val id: String,
    val title: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val email: String,
    val dateOfBirth: String,
    val registerDate: String,
    val phone: String,
    val picture: String
)