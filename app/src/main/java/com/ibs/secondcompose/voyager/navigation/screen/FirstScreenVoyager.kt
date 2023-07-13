package com.ibs.secondcompose.voyager.navigation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.ibs.secondcompose.navigation.utils.NavigationScreen

object FirstScreenVoyager : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
//                navigator.push(SecondScreenVoyager)
                // Todo we can also Write this
//                navigator push SecondScreenVoyager
//                navigator += SecondScreenVoyager

                navigator.push(ThirdScreenVoyager("Praveen Sundriyal"))

            }) {
                Text(text = "Click Here")
            }
        }
    }

}