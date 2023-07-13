package com.ibs.secondcompose.scaffold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ibs.secondcompose.ui.theme.SecondComposeTheme

class ScaffoldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondComposeTheme {
                Surface {
                    Scaffold()
                }
            }
        }
    }
}


@Composable
fun Scaffold() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Home")
                },
                contentColor = Color.Black,
                backgroundColor = Color.Yellow,
                elevation = 0.dp,
                navigationIcon = {
                    Icon(Icons.Default.Menu, contentDescription = "")
                },
                actions = {
                    Icon(Icons.Default.Add, contentDescription = "")
                    Icon(Icons.Default.MoreVert, contentDescription = "")
                }
            )
        },

        floatingActionButton = {
            FloatingActionButton(onClick = {

            }) {
                Icon(Icons.Default.Add, contentDescription = "")
            }
        },

        bottomBar = {
            BottomAppBar {
                Icon(imageVector = Icons.Default.Person, contentDescription = "")
                Icon(imageVector = Icons.Default.Menu, contentDescription = "")
            }
        }
    ) {

    }

}











