package com.example.instagramloginpage.login.data.network

import com.example.instagramloginpage.login.data.network.network.response.LoginService

class LoginRepository {
    private val api = LoginService()

    suspend fun doLogin(user:String,password:String):Boolean{
        return api.doLogin(user,password)
    }
}