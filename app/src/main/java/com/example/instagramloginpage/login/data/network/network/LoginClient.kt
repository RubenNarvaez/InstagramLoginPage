package com.example.instagramloginpage.login.data.network.network

import com.example.instagramloginpage.login.data.network.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

interface LoginClient {
    @GET("v3/f78c9d33-28b1-4f81-9cf1-6d6ff78fa014")
    //suspend fun is used when we work with coroutines
    suspend fun doLogin():Response<LoginResponse>
}