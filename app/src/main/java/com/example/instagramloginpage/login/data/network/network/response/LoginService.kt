package com.example.instagramloginpage.login.data.network.network.response

import com.example.instagramloginpage.core.RetrofitHelper
import com.example.instagramloginpage.login.data.network.network.LoginClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//The service has to manage all the endpoints that the client send
class LoginService {
    //we create the retrofit that we need
    private val retrofit = RetrofitHelper.getRetrofit()

    //We return a Boolean because the parameter success that we call from the client is a Boolean
    suspend fun doLogin(user:String, password:String):Boolean{
        //Now we call a dispatcher.io to create a new thread
        return withContext(Dispatchers.IO){
            //We create a variable that allows us see inside the class doLogin from the login client
            val response = retrofit.create(LoginClient::class.java).doLogin()
            //we can si inside the body of our response to se "success" that is the value of our data clas loginResponse
            response.body()?.success ?: false
        }
    }

}