package com.ibs.secondcompose.checkbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ibs.secondcompose.ui.theme.SecondComposeTheme

class CheckBox : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondComposeTheme {
                Surface {
                    CheckBoxUI()
                }
            }
        }
    }
}


// Todo This is normal Check Box We can not modified this check box --> For Modifying we have to create Custom check box
@Composable
fun CheckBoxUI() {

    var isChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = {
                isChecked = it
            },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Green,
                uncheckedColor = Color.Gray,
                checkmarkColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        CustomCheckBox()
    }
}


// Todo This is Custom Check Box

@Composable
fun CustomCheckBox() {

    var isChecked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(),
        horizontalArrangement = Arrangement.Center,
    ) {

        Card(
            elevation = 0.dp,
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color.White,
            border = BorderStroke(1.dp, color = Color.Gray)
        ) {
            Box(modifier = Modifier
                .background(
                    if (isChecked) Color.Green else Color.White
                ).clickable {
                    isChecked = !isChecked
                }
                .size(25.dp),
                contentAlignment = Alignment.Center
            ) {
                if (isChecked) {
                    Icon(Icons.Default.Check, contentDescription = "", tint = Color.White)
                }
            }
        }

        Text(
            text = "Accept all term and conditions",
            modifier = Modifier
                .padding(start = 5.dp)
                .align(CenterVertically)
        )

    }

}












