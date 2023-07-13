package com.ibs.secondcompose.viewpager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.ibs.secondcompose.ui.theme.SecondComposeTheme

class OnBoardingActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondComposeTheme {
                Surface {
                    OnBoardingScreen()
                }
            }
        }
    }
}