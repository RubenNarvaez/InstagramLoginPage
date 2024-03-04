package com.example.instagramloginpage.login

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramloginpage.R

@Composable
//How can I tel to this login screen that is going to receive a ViewModel parameter?
//fun LoginScreen() {

//For now we are going to add a parameter viewModel we don't have it yet but we are going to add later
fun LoginScreen(loginViewModel: LoginViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center), loginViewModel)
        Footer(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun Footer(modifier: Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Divider(
            Modifier
                .background(Color(0xFFf9f9f9))
                .height(1.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(24.dp))
        BottomLine()
        Spacer(modifier = Modifier.size(24.dp))
    }
}

@Composable
fun BottomLine() {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            text = "Don't have an account",
            fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 8.dp),
            fontWeight = FontWeight.Bold,
            color = Color(0xffb5b5b5)
        )

        Text(
            text = "Sign up.",
            fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 8.dp),
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4EA8E9)
        )
    }
}

@Composable
//Here we are going to work wth the ViewModel, so we have to add the ViewModel parameter here
//fun Body(modifier: Modifier) {
fun Body(modifier: Modifier, loginViewModel: LoginViewModel) {

    //Now we can erase the email var because we are going to pass it through the ViewModel
    //var email by rememberSaveable { mutableStateOf("") }
    //var password by rememberSaveable { mutableStateOf("") }
    ///var loginEnabled by rememberSaveable { mutableStateOf(false) }

    //Here we going to create a val that take the value emal from the ViewModel
    val email: String by loginViewModel.email.observeAsState(initial = "")
    val password by loginViewModel.password.observeAsState(initial = "")
    val isLoginEnabled by loginViewModel.isLoginEnabled.observeAsState(initial = false)

    Column(modifier = modifier) {
        LogoImage(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))

        //This function needs a onChangedListener that is no associated wth the view model
        //EmailSignIn(email) { email = it }

        EmailSignIn(email) {
            //We create the function onLoginChanged() that is going to be on LoginViewModel
            //This function needs a parameter that s the same change of the email.
            loginViewModel.onLoginChanged(it, password = password)
        }

        Spacer(modifier = Modifier.size(4.dp))


        PasswordSignIn(password) {
            loginViewModel.onLoginChanged(email = email, it)
        }


        Spacer(modifier = Modifier.size(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.size(16.dp))
        LoginButton(isLoginEnabled)
        Spacer(modifier = Modifier.size(16.dp))
        LoginDivider()
        Spacer(modifier = Modifier.size(32.dp))
        SocialLogin()
    }
}

@Composable
fun SocialLogin() {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fb),
            contentDescription = "Micro facebook logo",
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = "Continue as Pato",
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 18.dp),
            color = Color(0xff4EA8E9)
        )

    }
}

@Composable
fun LoginDivider() {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Divider(
            Modifier
                .background(Color(0xFFf9f9f9))
                .height(1.dp)
                .weight(1f)
        )
        Text(
            text = "OR",
            modifier = Modifier.padding(horizontal = 12.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xffb5b5b5)

        )
        Divider(
            Modifier
                .background(Color(0xFFf9f9f9))
                .height(1.dp)
                .weight(1f)
        )

    }
}

@Composable
fun LoginButton(loginEnabled: Boolean) {
    Button(
        onClick = {}, enabled = loginEnabled, colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4EA8E9),
            disabledContainerColor = Color(0xFF78C8F9),
            contentColor = Color.White,
            disabledContentColor = Color.White
        ), modifier = Modifier.fillMaxWidth()
    ) {
        Text("Log In")
    }/*containerColor: Color,
        private val contentColor: Color,
        private val disabledContainerColor: Color,
        private val disabledContentColor: Color,*/
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Forgot password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9),
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordSignIn(password: String, onTextChanged: (String) -> Unit) {

    var passwordVisibility by remember { mutableStateOf(false) }


    TextField(
        value = password,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Password") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            focusedTextColor = Color(0xFF121212),
            unfocusedTextColor = Color(0xFF1A1A1A),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Black,
            containerColor = Color(0xFFFAFAFA)
        ),
        trailingIcon = {
            val image = if (passwordVisibility) {
                Icons.Default.Person
            } else {
                Icons.Default.Search
            }
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(imageVector = image, contentDescription = "Password visibility state")
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else PasswordVisualTransformation()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailSignIn(email: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { onTextChanged(it) },
        maxLines = 1,

        colors = TextFieldDefaults.textFieldColors(
            focusedTextColor = Color(0xFFB2B2B2),
            unfocusedTextColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Black,
            containerColor = Color(0xFFFAFAFA),
        ),
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Phone number, username or email") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
    )
}

@Composable
fun LogoImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.insta),
        contentDescription = "Instagram Logo",
        modifier = modifier
    )
}

@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(imageVector = Icons.Default.Close,
        contentDescription = "Close app",
        modifier = modifier.clickable { activity.finish() })
}
