package com.example.deliverytesttask.framework

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.example.core.data.UserRepository
import com.example.core.interactors.GetUserInfo
import com.example.core.interactors.GetUsersList
import com.example.deliverytesttask.framework.datasource.ApiUserDataSource
import com.example.deliverytesttask.framework.datasource.RoomUserDataSource
import com.example.deliverytesttask.framework.datasource.db.Interactors

class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()

        val userRepository = UserRepository(
            RoomUserDataSource(
                this
            ),
            if (isInternetAvailable()) ApiUserDataSource() else null
        )

        ViewModelFactory.inject(
            this, Interactors(
                GetUserInfo(userRepository),
                GetUsersList(userRepository)
            )
        )

    }

    private fun isInternetAvailable(): Boolean {
        val cm = (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
        return cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
    }


}