package com.herojit.srijantask.viewsmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.herojit.srijantask.interfaces.DashboardCallbacks

class DashboardVMFactory(dashResultCallback: DashboardCallbacks) : ViewModelProvider.Factory {
    val callback: DashboardCallbacks = dashResultCallback
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DashboardViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DashboardViewModel(callback) as T
        }
        throw IllegalArgumentException("Unable to construct viewmodel")
    }
}