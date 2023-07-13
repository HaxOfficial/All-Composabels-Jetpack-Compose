package com.ibs.secondcompose.suggestionchip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ibs.secondcompose.ui.theme.Purple700
import com.ibs.secondcompose.ui.theme.Purple80
import com.ibs.secondcompose.ui.theme.PurpleGrey40
import com.ibs.secondcompose.ui.theme.SecondComposeTheme

class SuggestionChips : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondComposeTheme {
                Surface {
                    SuggestionChipsLayout()
                }
            }
        }
    }
}

@Composable
fun SuggestionChipsLayout() {

    val chipsData by remember { mutableStateOf(listOf("India", "France", "Spain")) }
    var chipsState by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            chipsData.forEach {
                SuggestionChipEachRow(label = it, selected = it == chipsState){chip->
                    chipsState = chip
                }
            }
        }
    }

}

@Composable
fun SuggestionChipEachRow(label: String, selected: Boolean, onChipChange: (String) -> Unit) {

    SuggestionChip(
        onClick = {
            if (!selected)
                onChipChange(label)
            else
                onChipChange("")
        },
        label = {
            Text(text = label)
        },
        //modifier = Modifier.padding(horizontal = 10.dp),
        shape = RoundedCornerShape(8.dp),
        colors = SuggestionChipDefaults.suggestionChipColors(
            containerColor = if (selected) Purple80 else Color.Transparent
        ),
        border = SuggestionChipDefaults.suggestionChipBorder(
            borderWidth = 1.dp,
            borderColor = if (selected) Color.Transparent else PurpleGrey40
        )

    )

    // Todo We can also use this for chips
//    ElevatedSuggestionChip(onClick = { /*TODO*/ }) {
//
//    }

}












