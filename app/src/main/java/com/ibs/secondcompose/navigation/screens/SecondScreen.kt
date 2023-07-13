package com.ibs.secondcompose.navigation.screens

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ibs.secondcompose.navigation.utils.NavigationScreen

@Composable
fun SecondScreen(context: Activity, navHostController: NavHostController, data: String?) {
    Column {
        Button(onClick = {
            //        val i = Intent(context, AnotherActivity::class.java).apply {
            //            putExtra("hello", "hello") // Todo We can also pass data also like this
            //        }
            //        context.startActivity(i)

            // Todo first method for backPress
            navHostController.navigate(NavigationScreen.ThirdScreen.route) {
                popUpTo(NavigationScreen.FirstScreen.route) {
                    inclusive =
                        true // Todo this is for when we backPress on thirdScreen we exit the application
                }
            }


            //        navHostController.navigate(NavigationScreen.ThirdScreen.route){
            //            launchSingleTop = true
            //        }
        }) {
            Text(text = "Go To Another Activity")

        }
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = data.toString())
    }
}