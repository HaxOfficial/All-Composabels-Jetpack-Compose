package com.ibs.secondcompose.voyager.navigation.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import cafe.adriel.voyager.navigator.Navigator
import com.ibs.secondcompose.ui.theme.SecondComposeTheme

class VoyagerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondComposeTheme {
                Surface {
                    Navigator(screen = FirstScreenVoyager)
                }
            }
        }
    }
}