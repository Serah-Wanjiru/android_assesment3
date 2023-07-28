package com.example.assesment3.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.assesment3.R
import com.example.assesment3.databinding.ActivityLoginBinding
import com.example.assesment3.databinding.ActivityMainBinding
import com.example.assesment3.model.LoginRequest
import com.example.assesment3.viewModel.LoginViewModel
import androidx.activity.viewModels

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    val loginViewModel:LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnHomepage.setOnClickListener {
            clearErrors()
            validateLogin()

        }
        loginViewModel.liveData.observe(this, Observer { LoginResponse ->
            Toast.makeText(this, LoginResponse.message, Toast.LENGTH_LONG).show()
//            startActivity(Intent(this, Homepage::class.java))
        })
        loginViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
            startActivity(Intent(this, Homepage::class.java))
        })
        binding.tvSignup.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
//        binding.tvlogin.setOnClickListener {
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//        }


    }

    fun validateLogin() {
        val email = binding.etUsername.text.toString()
        val password = binding.etPassword.text.toString()

        var error = false
        if (email.isBlank()) {
            binding.tilUsername.error = "Insert userName"
            error = true
        }
        if (password.isBlank()) {
            binding.tilPassword.error = "Enter Password"
            error = true
        }

        if (!error) {
            val loginRequest = LoginRequest(
                password = password,
                email = email,
            )
            loginViewModel.loginUser(loginRequest)
            Toast.makeText(
                this, "login was successful",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun clearErrors() {
        binding.tilUsername.error = null
        binding.tilPassword.error = null

    }


}