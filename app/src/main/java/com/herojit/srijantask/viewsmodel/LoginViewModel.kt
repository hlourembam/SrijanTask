package com.herojit.srijantask.viewsmodel

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import com.herojit.srijantask.interfaces.LoginCallbacks

class LoginViewModel(callback: LoginCallbacks) : ViewModel() {

    var listener: LoginCallbacks = callback

    fun getUsernameTextWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                listener.getTextWatcher(1, editable.toString())
            }
        }
    }

    fun getPasswordTextWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                listener.getTextWatcher(2, editable.toString())
            }
        }
    }


    fun onLoginClicked(@NonNull view: View?) {
        listener.getLoginClick()
    }

    fun onshow(@NonNull view: View?) {
        listener.passwordHideShow(2)
    }

    fun onhide(@NonNull view: View?) {
        listener.passwordHideShow(1)
    }

}