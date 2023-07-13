package com.ibs.secondcompose.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class SwitchAndManageState : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowSwitch()
        }
    }
}

@Composable
fun ShowSwitch() {

    val isChecked = remember { mutableStateOf(true) }

    Switch(
        checked = isChecked.value,
        onCheckedChange = {
            isChecked.value = it
        },
        modifier = Modifier.run {
            size(20.dp)
            padding(10.dp)
        }
    )
}