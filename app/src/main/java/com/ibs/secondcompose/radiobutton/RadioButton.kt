package com.ibs.secondcompose.radiobutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ibs.secondcompose.ui.theme.SecondComposeTheme

class RadioButton : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondComposeTheme {
                Surface {
                    RadioButtonUI()
                }
            }
        }
    }
}

@Composable
fun RadioButtonUI() {
    val genderList by remember { mutableStateOf(listOf("Male", "Female", "Others")) }
    var genderState by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            genderList.forEach {
                Row {
                    Text(
                        text = it,
                        modifier = Modifier.align(CenterVertically)
                    )

                    RadioButton(selected = genderState == it, onClick = {
                        genderState = it
                    },
                    colors = RadioButtonDefaults.colors(selectedColor = Color.Green, unselectedColor = Color.Gray)
                        )
                }
            }
        }

        Text(text = genderState)

    }

}









