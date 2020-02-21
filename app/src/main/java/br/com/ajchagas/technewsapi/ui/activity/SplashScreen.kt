package br.com.ajchagas.technewsapi.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.com.ajchagas.technewsapi.R

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            //start main activity
            startActivity(Intent(this@SplashScreen, ViewPageActivity::class.java))
            //finish this activity
            finish()
        },500)
    }
}
