package com.ibs.secondcompose.titlecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ibs.secondcompose.ui.theme.SecondComposeTheme

class CustomTitleCard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondComposeTheme {
                Surface {
                    CustomTitleBar()
                }
            }
        }
    }
}


@Composable
fun CustomTitleBar() {
    var title by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {

            Card(
                backgroundColor = Color.Transparent,
                shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
                border = BorderStroke(1.dp, Color.Gray)
            ) {
                Text(text = "Title", modifier = Modifier.padding(horizontal = 20.dp))
            }

            OutlinedTextField(value = title, onValueChange = {
                title = it
            },
                shape = RoundedCornerShape(0.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
        }
    }

}
















