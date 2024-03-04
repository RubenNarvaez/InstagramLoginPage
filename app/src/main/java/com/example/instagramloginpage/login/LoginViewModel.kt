package com.example.instagramloginpage.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns


class LoginViewModel : ViewModel() {

    //We call _email to the LiveData value that is going to change in the ViewModel
    private val _email = MutableLiveData<String>()
    private val _passwword = MutableLiveData<String>()
    private val _isLoginEnabled = MutableLiveData<Boolean>()

    //We make a public val that copies the value of the mutable LiveData
    val email: LiveData<String> = _email
    val password: LiveData<String> = _passwword
    val isLoginEnabled: LiveData<Boolean> = _isLoginEnabled
    //With this we can do that our views can read but no Write

    fun onLoginChanged(email: String,password:String) {
        //in ths function we just changed the pri   vate val _email, that change the public val email.
        //this public val change the observe state of email.
        _email.value = email
        _passwword.value = password
        _isLoginEnabled.value = enableLogin(email,password)
    }

    fun enableLogin(email: String, password: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length>6


}