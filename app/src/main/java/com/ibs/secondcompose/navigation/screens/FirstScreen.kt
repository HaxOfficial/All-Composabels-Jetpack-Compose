package com.ibs.secondcompose.navigation.screens

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.ibs.secondcompose.navigation.utils.NavigationScreen

@Composable
fun FirstScreen(navHostController: NavHostController) {

    Button(onClick = {
        // Todo this is for data transfer from one Screen to another
        navHostController.navigate(NavigationScreen.SecondScreen.createRoute("Hello Praveen Sundriyal"))
    }) {
        Text(text = "Go To Next Screen")
    }
}