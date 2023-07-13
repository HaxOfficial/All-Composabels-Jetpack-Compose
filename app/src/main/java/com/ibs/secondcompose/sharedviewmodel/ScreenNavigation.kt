package com.ibs.secondcompose.sharedviewmodel

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ibs.secondcompose.sharedviewmodel.viewmodel.SharedViewModel

@Composable
fun ScreenNavigation() {
    val navHostController = rememberNavController()

    val viewModel:SharedViewModel = viewModel()

    NavHost(navController = navHostController, startDestination = FIRST_SCREEN) {
        composable(FIRST_SCREEN){
            FirstScreenComp(navHostController, viewModel)
        }
        composable(SECOND_SCREEN) {
            SecondScreenComp(viewModel)
        }
    }

}

const val FIRST_SCREEN = "FIRST_SCREEN"
const val SECOND_SCREEN = "SECOND_SCREEN"

