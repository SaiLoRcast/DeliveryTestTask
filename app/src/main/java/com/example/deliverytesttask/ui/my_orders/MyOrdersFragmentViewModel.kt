package com.example.deliverytesttask.ui.my_orders

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.core.domain.Order
import com.example.core.domain.UsersData
import com.example.deliverytesttask.framework.BaseViewModel
import com.example.deliverytesttask.framework.datasource.db.Interactors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyOrdersFragmentViewModel(application: Application, interactors: Interactors) :
    BaseViewModel(application, interactors) {

    val ordersList = MutableLiveData<List<Order>>()

    fun loadMyOrders() {
        viewModelScope.launch {
            withContext(Dispatchers.Default){
                ordersList.postValue(interactors.getMyOrders())
            }
        }
    }
}

