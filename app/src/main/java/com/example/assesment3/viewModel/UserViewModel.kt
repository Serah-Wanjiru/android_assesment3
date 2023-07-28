package com.example.assesment3.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assesment3.model.RegisterRequest
import com.example.assesment3.model.RegisterResponse
import com.example.assesment3.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    val userRepo=UserRepository()
    val regLiveData=MutableLiveData<RegisterResponse>()
    val  errLiveData=MutableLiveData<String>()


    fun registerUser(registerRequest: RegisterRequest){
        viewModelScope.launch {
            val response=userRepo.register(registerRequest)
            if (response.isSuccessful){
                regLiveData.postValue(response.body())
            }
            else{
                errLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}