package com.example.assesment3.repository

import com.example.assesment3.api.ApiClient
import com.example.assesment3.api.ApiInterface
import com.example.assesment3.model.LoginRequest
import com.example.assesment3.model.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class LoginRepository {
    var client = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun loginUser(loginRequest: LoginRequest):Response<LoginResponse>{
        return withContext(Dispatchers.IO){
            client.loginUser(loginRequest)
        }
    }
}