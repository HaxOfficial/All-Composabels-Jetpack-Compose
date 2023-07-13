package com.ibs.secondcompose.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import com.ibs.secondcompose.Greeting
import com.ibs.secondcompose.ui.theme.SecondComposeTheme

class DemoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondComposeTheme {
                App()
            }
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun App() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    DemoName()
                },
                navigationIcon = {
                    Icons()
                },
                actions = {
                    ActionsIcons()
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Add, contentDescription = "Add")
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        Greeting(name = "Kotlin Multiplatform Mobile")
    }
}

@Composable
fun ActionsIcons() {
    IconButton(onClick = {
        println("Menu Clicked")
    }) {
        Icon(Icons.Filled.Notifications, contentDescription = "")
    }
    IconButton(onClick = {
        println("Menu Clicked")
    }) {
        Icon(Icons.Filled.Search, contentDescription = "")
    }
}


@Composable
fun DemoName() {
    Text(text = "Demo App")
}

@Composable
fun Icons() {
    IconButton(onClick = {
        println("Menu Clicked")
    }) {
        Icon(Icons.Filled.Menu, contentDescription = "")
    }
}