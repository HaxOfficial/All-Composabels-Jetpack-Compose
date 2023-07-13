package com.ibs.secondcompose.navigation.navigation1

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ibs.secondcompose.navigation.screens.FirstScreen
import com.ibs.secondcompose.navigation.screens.SecondScreen
import com.ibs.secondcompose.navigation.screens.ThirdScreen
import com.ibs.secondcompose.navigation.utils.NavigationScreen

@Composable
fun StartNavigation(context:Activity) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationScreen.FirstScreen.route){
        composable(NavigationScreen.FirstScreen.route){
            FirstScreen(navController)
        }

        composable(NavigationScreen.SecondScreen.route){
            val data = it.arguments?.getString("data")
            SecondScreen(context, navController, data)
        }

        composable(NavigationScreen.ThirdScreen.route){
            ThirdScreen()
        }
    }
}