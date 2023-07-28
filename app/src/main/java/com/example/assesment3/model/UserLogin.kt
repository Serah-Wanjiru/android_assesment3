package com.example.assesment3.model

import com.google.gson.annotations.SerializedName

data class UserLogin(
    @SerializedName("user_id") var  userId:String,
    var email:String,
    var password:String,
)
