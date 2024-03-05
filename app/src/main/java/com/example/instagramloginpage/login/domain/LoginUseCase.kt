package com.example.instagramloginpage.login.domain

import com.example.instagramloginpage.login.data.network.LoginRepository

class LoginUseCase {
    val repository = LoginRepository()

    suspend operator fun invoke(user:String,pasword:String):Boolean{
        return repository.doLogin(user,pasword)
    }
}