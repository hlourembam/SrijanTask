package com.herojit.srijantask.viewsmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.herojit.srijantask.interfaces.LoginCallbacks

class LoginVMFactory(loginResultCallback: LoginCallbacks) : ViewModelProvider.Factory {
    val callback: LoginCallbacks = loginResultCallback
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LoginViewModel(callback) as T
        }
        throw IllegalArgumentException("Unable to construct viewmodel")
    }
}