package com.example.deliverytesttask.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.deliverytesttask.framework.datasource.db.Interactors
import com.example.deliverytesttask.framework.BaseApp

open class BaseViewModel(application: Application, protected val interactors: Interactors) : AndroidViewModel(application){
    protected val application : BaseApp = getApplication()
}