package com.herojit.srijantask.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.herojit.srijantask.R
import com.herojit.srijantask.databinding.DashboardBinding
import com.herojit.srijantask.databinding.LoginBinding
import com.herojit.srijantask.interfaces.DashboardCallbacks
import com.herojit.srijantask.interfaces.LoginCallbacks
import com.herojit.srijantask.viewsmodel.DashboardVMFactory
import com.herojit.srijantask.viewsmodel.DashboardViewModel
import com.herojit.srijantask.viewsmodel.LoginVMFactory
import com.herojit.srijantask.viewsmodel.LoginViewModel

class Dashboard : AppCompatActivity(), DashboardCallbacks {

    lateinit var databinding: DashboardBinding
    lateinit var viewModel: DashboardViewModel
    var username: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView<DashboardBinding>(this, R.layout.dashboard)
        viewModel =
            ViewModelProviders.of(this, DashboardVMFactory(this))[DashboardViewModel::class.java]
        databinding.model = viewModel
        viewModel.listener = this

        val bundle = intent.extras
        if (bundle != null) {
            username = bundle.getString("username")
        }

        if (username != null && username!!.length > 0) {
            databinding.txthello.text = "Hello " + username
        }

    }
}