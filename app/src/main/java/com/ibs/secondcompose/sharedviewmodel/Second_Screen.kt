package com.ibs.secondcompose.sharedviewmodel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ibs.secondcompose.sharedviewmodel.viewmodel.SharedViewModel

@Composable
fun SecondScreenComp(viewModel: SharedViewModel) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = viewModel.res.value)
    }
}