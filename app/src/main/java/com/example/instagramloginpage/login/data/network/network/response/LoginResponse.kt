package com.example.instagramloginpage.login.data.network.network.response

import com.google.gson.annotations.SerializedName
//We use the name response just to know that is a response from a client or API
//@SerializedName is used because when we obfuscate the code this action can fail
data class LoginResponse(@SerializedName("success") val success: Boolean)