package com.example.assesment3.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.assesment3.databinding.ActivityMainBinding
import com.example.assesment3.model.RegisterRequest
import com.example.assesment3.viewModel.UserViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val  userViewModel:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()

        binding.tvlogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignUp.setOnClickListener {
            validateSignUp()
        }
        userViewModel.regLiveData.observe(this) { regResponse ->
            Toast.makeText(this, regResponse.message, Toast.LENGTH_LONG).show()
            startActivity(Intent(this, LoginActivity::class.java))
            binding.pbload.visibility = View.GONE
        }
        userViewModel.errLiveData.observe(this) { err ->
            Toast.makeText(this, err, Toast.LENGTH_LONG).show()
            binding.pbload.visibility = View.GONE
        }
    }


    fun validateSignUp() {
        val firstName = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val pass = binding.etPassword.text.toString()
        val confirmPassword = binding.etConfirmPassword.text.toString()
        val email = binding.etEmail.text.toString()
        var error = false

        if (firstName.isBlank()) {
            binding.tilFirstName.error = "First name is required"
            error = true
        }
        if (lastName.isBlank()) {
            binding.tilLastName.error = "Last name is required"
            error = true
        }
        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"
            error = true
        }
        if (pass.isBlank()) {
            binding.tillPass.error = "Password is required"
            error = true
        }
        if (confirmPassword.isBlank()) {
            binding.tilConfirmPassword.error = "password confirmation is required"
            error = true
        }
        if (pass != confirmPassword) {
            binding.tilConfirmPassword.error = "pasword and confirmation do not match"
            error = true
        }
        if (!error) {
            var registerRequest=RegisterRequest(
                firstName=firstName,
                lastName=lastName,
                email=email,
                password = confirmPassword,
            )
            binding.pbload.visibility=View.VISIBLE
            userViewModel.registerUser(registerRequest)


        }

    }
}