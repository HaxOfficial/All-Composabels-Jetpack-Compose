package com.ibs.secondcompose.suggestionchip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.ibs.secondcompose.ui.theme.Purple80
import com.ibs.secondcompose.ui.theme.PurpleGrey40
import com.ibs.secondcompose.ui.theme.SecondComposeTheme

class FilterChipLayout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondComposeTheme {
                Surface {
                    FilterChipLayoutUI()
                }
            }
        }
    }
}

@Composable
fun FilterChipLayoutUI() {
    val list by remember { mutableStateOf(listOf("chip1", "chip2", "chip3", "chip4", "chip5")) }

    val tempList: Set<Int> = emptySet()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        FilterChips(list = list, tempList = tempList)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChips(list: List<String>, tempList: Set<Int>) {

    var multipleChecked by rememberSaveable { mutableStateOf(tempList) }

    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        crossAxisSpacing = 16.dp,
        mainAxisSpacing = 16.dp
    ) {
        list.forEachIndexed { index, s ->
            FilterChip(
                selected = multipleChecked.contains(index),
                onClick = {
                    multipleChecked = if (multipleChecked.contains(index))
                        multipleChecked.minus(index)
                    else
                        multipleChecked.plus(index)
                },
                label = {
                    Text(text = s)
                },

                border = FilterChipDefaults.filterChipBorder(
                    borderColor = if (!multipleChecked.contains(index)) PurpleGrey40 else Color.Transparent,
                    borderWidth = if (multipleChecked.contains(index)) 0.dp else 2.dp
                ),
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = if (multipleChecked.contains(index)) Purple80 else Color.Transparent
                ),

                shape = RoundedCornerShape(8.dp),
                trailingIcon = {
                    if (multipleChecked.contains(index)) Icon(
                        Icons.Default.Check,
                        contentDescription = ""
                    ) else null
                }

            )

        }
    }

}













