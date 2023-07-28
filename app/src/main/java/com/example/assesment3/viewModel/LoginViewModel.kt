package com.example.assesment3.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assesment3.model.LoginRequest
import com.example.assesment3.model.LoginResponse
import com.example.assesment3.repository.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {
    val liveData = MutableLiveData<LoginResponse>()
    val errorLiveData = MutableLiveData<String>()
    val loginRepository = LoginRepository()

    fun loginUser(loginRequest: LoginRequest) {
        viewModelScope.launch {
            val response = loginRepository.loginUser(loginRequest)
            if (response.isSuccessful){
                liveData.postValue(response.body())
            } else {
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}
