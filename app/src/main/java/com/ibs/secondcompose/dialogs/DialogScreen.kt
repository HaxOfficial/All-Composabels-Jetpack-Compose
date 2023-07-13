package com.ibs.secondcompose.dialogs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.ibs.secondcompose.ui.theme.SecondComposeTheme
import okio.Okio

class DialogScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondComposeTheme {
                Surface {
                    DialogScreenUI()
                }
            }
        }
    }
}


// Todo This is normal Dialog
@Composable
fun DialogScreenUI() {

    var isDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            isDialog = true
        }) {
            Text(text = "Open Dialog")
        }

        Spacer(modifier = Modifier.height(20.dp))

        AlertDialogUI()
    }

    if (isDialog)

        Dialog(onDismissRequest = {
            isDialog = false
        }) {
            CircularProgressIndicator()
        }

}


// Todo This is Alert Dialog

@Composable
fun AlertDialogUI() {

    var isDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            isDialog = true
        }) {
            Text(text = "Open Alert Dialog")
        }


        if (isDialog) {
            AlertDialog(onDismissRequest = {
//                isDialog = false
            },
                title = {
                    Text(text = "Dialog Box")
                },
                text = {
                    Text(text = "This is Dialog Box Contents")
                },
                modifier = Modifier.fillMaxWidth(),
                buttons = {
                    Button(onClick = {
                        isDialog = false
                    }, modifier = Modifier.align(CenterHorizontally)) {
                        Text(text = "OK")
                    }
                }
            )
        }
    }

}









