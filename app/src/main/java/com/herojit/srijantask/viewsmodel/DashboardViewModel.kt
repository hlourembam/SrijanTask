package com.herojit.srijantask.viewsmodel

import androidx.lifecycle.ViewModel
import com.herojit.srijantask.interfaces.DashboardCallbacks
import com.herojit.srijantask.interfaces.LoginCallbacks

class DashboardViewModel(callback: DashboardCallbacks) : ViewModel() {
    var listener: DashboardCallbacks? = callback
}