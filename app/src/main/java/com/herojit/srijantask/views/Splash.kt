package com.herojit.srijantask.views

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.herojit.srijantask.R
import com.herojit.srijantask.views.Login
import kotlinx.android.synthetic.main.splash.*

class Splash : AppCompatActivity() {
    var zoomin: Animation? = null
    var zoomout: Animation? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)

        zoomin = AnimationUtils.loadAnimation(this, R.anim.zoomin)
        zoomout = AnimationUtils.loadAnimation(this, R.anim.zoomout)
        txt_title.setAnimation(zoomin);

        Handler().postDelayed({ // This method will be executed once the timer is over
            val intent = Intent(this@Splash, Login::class.java)
            startActivity(intent)
            finish()
        }, 2000)

    }


}