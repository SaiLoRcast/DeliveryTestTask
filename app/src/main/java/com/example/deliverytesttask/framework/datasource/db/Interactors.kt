package com.example.deliverytesttask.framework.datasource.db

import com.example.core.interactors.GetUserInfo
import com.example.core.interactors.GetUsersList

data class Interactors(
    val getUserInfo: GetUserInfo,
    val getUsersList: GetUsersList
)