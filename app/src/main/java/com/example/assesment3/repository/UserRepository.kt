package com.example.assesment3.repository

import com.example.assesment3.api.ApiClient
import com.example.assesment3.api.ApiInterface
import com.example.assesment3.model.RegisterRequest
import com.example.assesment3.model.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient=ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun register(registerRequest: RegisterRequest):Response<RegisterResponse>{
        return withContext(Dispatchers.IO){
            apiClient.registerUser(registerRequest)
        }
    }
}