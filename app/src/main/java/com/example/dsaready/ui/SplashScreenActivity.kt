package com.example.dsaready.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.dsaready.MainActivity
import com.example.dsaready.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 1800

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadSplashScreen()
    }
    private fun loadSplashScreen(){
        Handler().postDelayed({
            // we used the postDelayed(Runnable, time) method to send a message with a delayed time.
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        },SPLASH_TIME_OUT)
    }
}