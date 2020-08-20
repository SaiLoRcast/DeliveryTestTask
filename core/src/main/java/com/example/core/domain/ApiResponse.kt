package com.example.core.domain

data class User(

    val id: String,
    val title: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val email: String,
    val dateOfBirth: String,
    val registerDate: String,
    val phone: String,
    val picture: String,
    val location: Location

) : java.io.Serializable

data class Location(

    val street: String,
    val city: String,
    val state: String,
    val country: String,
    val timezone: String

): java.io.Serializable

data class UsersData(
    val data: List<User>
)

data class Order(
    val id: Int,
    val locationFrom: String,
    val dateFrom: String,
    val locationTo: String,
    val dateTo: String,
    val cost: String
)