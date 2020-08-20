package com.example.deliverytesttask.ui.confirm_order_fragment

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.core.data.UserRepository
import com.example.core.domain.Order
import com.example.core.domain.UsersData
import com.example.core.interactors.GetMyOrders
import com.example.core.interactors.GetUserInfo
import com.example.core.interactors.GetUserLocation
import com.example.deliverytesttask.framework.BaseViewModel
import com.example.deliverytesttask.framework.ViewModelFactory
import com.example.deliverytesttask.framework.datasource.ApiUserDataSource
import com.example.deliverytesttask.framework.datasource.RoomUserDataSource
import com.example.deliverytesttask.framework.datasource.db.Interactors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ConfirmOrderFragmentViewModel(application: Application, interactors: Interactors) :
    BaseViewModel(application, interactors) {

    fun saveOrdersList(orders: List<Order>) {
        val userRepository = UserRepository(
            RoomUserDataSource(
                application.baseContext
            ),
            if (isInternetAvailable()) ApiUserDataSource() else null
        )
        viewModelScope.launch {
            withContext(Dispatchers.Default){
                 userRepository.saveMyOrders(orders)
            }
        }

        ViewModelFactory.inject(
            application, Interactors(
                GetUserInfo(userRepository),
                GetUserLocation(userRepository),
                GetMyOrders(userRepository)
            )
        )
    }

    fun isInternetAvailable(): Boolean {
        val cm = (application.baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
        return cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
    }
}

