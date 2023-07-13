package com.ibs.secondcompose.navigationdrawer

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import com.ibs.secondcompose.ui.theme.SecondComposeTheme
import kotlinx.coroutines.launch

class NavigationDrawer : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondComposeTheme {
                Surface {
                    val scaffoldState = rememberScaffoldState()
                    val scope = rememberCoroutineScope()
                    Scaffold(
                        scaffoldState = scaffoldState,
                        drawerContent = {
                            Column {
                                IconButton(onClick = {
                                    scope.launch {
                                        scaffoldState.drawerState.close()
                                    }
                                }) {
                                    Icon(Icons.Default.Close, contentDescription = "", tint = Color.Blue)
                                }

                                Text(text = "Drawer Content")
                            }
                        },
                        drawerGesturesEnabled = false
                    ) {
                        CreateDrawer(scaffoldState = scaffoldState)
                    }
                }
            }
        }
    }
}


@Composable
fun CreateDrawer(scaffoldState: ScaffoldState) {

    val scope = rememberCoroutineScope()

    IconButton(onClick = {
        scope.launch {
            scaffoldState.drawerState.open()
        }
    }) {
        Icon(Icons.Default.List, contentDescription = "", tint = Color.Blue)
    }

}













