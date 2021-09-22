package com.herojit.srijantask.views

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.herojit.srijantask.R
import com.herojit.srijantask.databinding.LoginBinding
import com.herojit.srijantask.interfaces.LoginCallbacks
import com.herojit.srijantask.viewsmodel.LoginVMFactory
import com.herojit.srijantask.viewsmodel.LoginViewModel
import android.view.Gravity




class Login : AppCompatActivity(), LoginCallbacks {

    lateinit var databinding: LoginBinding
    lateinit var viewModel: LoginViewModel
    var UserName: String = ""
    var Password: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView<LoginBinding>(this, R.layout.login)
        viewModel = ViewModelProviders.of(this, LoginVMFactory(this))[LoginViewModel::class.java]
        databinding.model = viewModel
        viewModel.listener = this

        checkButton(1)


    }

    override fun getTextWatcher(flag: Int, Value: String) {
        when (flag) {
            1 -> {
                UserName = databinding.editUsername.getText().toString()
                if (!isValidUsername(UserName)) {
                    checkButton(1)
                    setToast(R.string.validusername)
                } else {
                    checkButton(2)
                }
            }
            2 -> {
                Password = databinding.editPassword.getText().toString()
                if (!isValidPassword(Password)) {
                    checkButton(1)
                    setToast(R.string.validpassword)
                } else {
                    checkButton(2)
                }
            }
        }
    }

    override fun getLoginClick() {
        setToast(R.string.LoginSuccessfully)
        val intent = Intent(this@Login, Dashboard::class.java)
        intent.putExtra("username", UserName)
        startActivity(intent)
    }

    fun setToast(SMS: Int) {
        val toast = Toast.makeText(this, SMS, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP, 0, 150)
        toast.show()
    }

    fun checkButton(flag: Int) {
        when (flag) {
            1 -> {
                databinding.btnLogin.isEnabled = false
                databinding.btnLogin.setBackgroundDrawable(getDrawable(R.drawable.btn_bg_gray))
            }
            2 -> {
                if (UserName != null && isValidUsername(UserName) &&
                    Password != null && isValidPassword(Password)
                ) {
                    databinding.btnLogin.isEnabled = true
                    databinding.btnLogin.setBackgroundDrawable(getDrawable(R.drawable.btn_bg))
                }
            }
        }
    }

    override fun passwordHideShow(flag: Int) {
        when (flag) {
            1 -> {
                databinding.showpassword.visibility = View.VISIBLE
                databinding.hidepassword.visibility = View.GONE
                databinding.editPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
            2 -> {
                databinding.showpassword.visibility = View.GONE
                databinding.hidepassword.visibility = View.VISIBLE
                databinding.editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    fun isValidUsername(password: String): Boolean {
        password?.let {
            val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{5,}$"
            val passwordMatcher = Regex(passwordPattern)

            return passwordMatcher.find(password) != null
        } ?: return false
    }

    fun isValidPassword(password: String): Boolean {
        password?.let {
            val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@!?_])(?=\\S+$).{5,}$"
            val passwordMatcher = Regex(passwordPattern)

            return passwordMatcher.find(password) != null
        } ?: return false
    }

    override fun onBackPressed() {
        // code here to show dialog
        super.onBackPressed() // optional depending on your needs
        moveTaskToBack(true)
    }
}