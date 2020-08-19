package com.example.deliverytesttask.ui.confirm_order_fragment

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.core.domain.UsersData
import com.example.deliverytesttask.framework.BaseViewModel
import com.example.deliverytesttask.framework.datasource.db.Interactors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ConfirmOrderFragmentViewModel(application: Application, interactors: Interactors) :
    BaseViewModel(application, interactors) {

//    val usersList = MutableLiveData<UsersData>()

//    fun loadUsersList() {
//        viewModelScope.launch {
//            withContext(Dispatchers.Default){
//                usersList.postValue(interactors.getUsersList())
//            }
//        }
//    }
}

