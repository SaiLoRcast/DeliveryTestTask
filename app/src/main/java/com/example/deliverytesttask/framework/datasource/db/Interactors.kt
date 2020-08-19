package com.example.deliverytesttask.framework.datasource.db

import com.example.core.interactors.GetUserInfo
import com.example.core.interactors.GetUserLocation

data class Interactors(
    val getUserInfo: GetUserInfo,
    val getUsersDeliveryTo: GetUserLocation
)