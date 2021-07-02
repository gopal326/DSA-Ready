package com.example.dsaready.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dsaready.R
import com.example.dsaready.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle(R.string.about)
    }
}