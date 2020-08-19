package com.example.deliverytesttask.ui.main_fragment

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.core.domain.User
import com.example.deliverytesttask.framework.BaseViewModel
import com.example.deliverytesttask.framework.datasource.db.Interactors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainFragmentViewModel(application: Application, interactors: Interactors) :
    BaseViewModel(application, interactors) {

    val userInfo = MutableLiveData<User>()

    fun loadUserInfo() {
        viewModelScope.launch {
            withContext(Dispatchers.Default){
                userInfo.postValue(interactors.getUserInfo())
            }
        }
    }

}