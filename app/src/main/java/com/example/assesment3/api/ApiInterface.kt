package com.example.assesment3.api

import com.example.assesment3.model.LoginRequest
import com.example.assesment3.model.LoginResponse
import com.example.assesment3.model.RegisterRequest
import com.example.assesment3.model.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/users/register")
    suspend fun registerUser(@Body registerRequest: RegisterRequest):Response<RegisterResponse>


    @POST("/userLogin/login")
    suspend fun loginUser(@Body LoginRequest:LoginRequest):Response<LoginResponse>
}