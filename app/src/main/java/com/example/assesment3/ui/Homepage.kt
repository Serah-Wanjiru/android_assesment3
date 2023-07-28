package com.example.assesment3.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assesment3.databinding.ActivityHomePageBinding

class Homepage: AppCompatActivity() {
    lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}