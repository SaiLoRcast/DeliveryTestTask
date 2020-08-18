package com.example.deliverytesttask.ui.create_order_fragment

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.core.domain.User
import com.example.deliverytesttask.framework.BaseViewModel
import com.example.deliverytesttask.framework.datasource.db.Interactors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CreateNewOrderFragmentViewModel(application: Application, interactors: Interactors) :
    BaseViewModel(application, interactors) {

//    val userInfo = MutableLiveData<User>()
//
//    fun loadUserInfo() {
//        viewModelScope.launch {
//            withContext(Dispatchers.Default){
//                userInfo.postValue(interactors.getUserInfo())
//            }
//        }
//    }

}