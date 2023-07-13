package com.ibs.secondcompose.voyager.navigation.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

object SecondScreenVoyager : Screen{
    @Composable
    override fun Content() {
        Text(text = "This is Second Screen")
    }

}