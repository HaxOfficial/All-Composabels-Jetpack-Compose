package com.ibs.secondcompose.sharedviewmodel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.ibs.secondcompose.sharedviewmodel.viewmodel.SharedViewModel

@Composable
fun FirstScreenComp(navHostController: NavHostController, viewModel:SharedViewModel) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = {
            viewModel.setData("Hello How are You")
            navHostController.navigate(SECOND_SCREEN)
        }) {
            Text(text = "Send Data", color = Color.White)
        }
    }
}