package com.ibs.secondcompose.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibs.secondcompose.ui.theme.SecondComposeTheme
import kotlin.math.acos

class LoginActivity : ComponentActivity() {

    private lateinit var activity: LoginActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            activity = this
            SecondComposeTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen()
                }
            }
        }
    }


    @Composable
    fun LoginScreen() {

        val userName = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Hello Again!\nWelcome\nBack",
                color = Color.Blue,
                fontSize = 25.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold
            )

            // Todo UserName
            OutlinedTextField(
                value = userName.value,
                onValueChange = {
                    userName.value = it
                },
                leadingIcon = {
                    Icon(Icons.Default.Person, contentDescription = "person")
                },
                label = {
                    Text(text = "Username")
                },
                placeholder = {
                    Text(text = "Enter Username")
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))


            // Todo Password
            OutlinedTextField(
                value = password.value,
                onValueChange = {
                    password.value = it
                },
                leadingIcon = {
                    Icon(Icons.Default.Info, contentDescription = "info")
                },
                label = {
                    Text(text = "Password")
                },
                placeholder = {
                    Text(text = "Enter Password")
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Todo Button
            OutlinedButton(
                onClick = {
                    logged(userName.value, password.value)
                },
                modifier = Modifier.fillMaxWidth()

            ) {
                Text(text = "Login")
            }
        }
    }

    private fun logged(username: String, password: String) {
        if (username == "jks" && password == "12345") {
            Toast.makeText(activity, "Logged", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(activity, "Wrong Credential", Toast.LENGTH_SHORT).show()
        }
    }
}

