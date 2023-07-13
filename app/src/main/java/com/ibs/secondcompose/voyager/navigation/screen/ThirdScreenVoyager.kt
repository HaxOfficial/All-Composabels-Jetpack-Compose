package com.ibs.secondcompose.voyager.navigation.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

//object ThirdScreenVoyager : Screen {
//    @Composable
//    override fun Content() {
//        Text(text = "Third Screen")
//    }
//}

data class ThirdScreenVoyager(val name:String) : Screen {
    @Composable
    override fun Content() {
        Text(text = "Hello $name")
    }

}