package com.ibs.secondcompose.snackbar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ibs.secondcompose.ui.theme.SecondComposeTheme
import kotlinx.coroutines.launch

class SnackBar : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondComposeTheme {
                Surface {
                    val scaffoldState = rememberScaffoldState()
                    Scaffold(
                        scaffoldState = scaffoldState
                    ) {
                        SnackBarUI(scaffoldState = scaffoldState)
                    }
                }
            }
        }
    }
}

@Composable
fun SnackBarUI(scaffoldState: ScaffoldState) {

    val scope = rememberCoroutineScope()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick = {
            scope.launch {
                scaffoldState.snackbarHostState.showSnackbar("Hey, This is Demo SnackBar")
            }
        }) {
            Text(text = "Show SnackBar")
        }
    }

}











