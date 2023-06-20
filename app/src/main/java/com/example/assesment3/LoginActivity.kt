package com.example.assesment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assesment3.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_login)
    }
}