package com.ibs.secondcompose.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.ibs.secondcompose.navigation.navigation1.StartNavigation
import com.ibs.secondcompose.ui.theme.SecondComposeTheme

class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondComposeTheme {
                Surface {
                    StartNavigation(this)
                }
            }
        }
    }
}