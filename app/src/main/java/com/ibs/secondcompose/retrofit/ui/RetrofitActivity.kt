package com.ibs.secondcompose.retrofit.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.ibs.secondcompose.retrofit.Post
import com.ibs.secondcompose.retrofit.util.ApiState
import com.ibs.secondcompose.ui.theme.SecondComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RetrofitActivity : ComponentActivity() {

    private val mainViewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    GetData(mainViewModel = mainViewModel)
                }
            }
        }
    }

    @Composable
    fun EachRow(post: Post) {
        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            elevation = 2.dp,
            shape = RoundedCornerShape(4.dp)
        ) {
            Text(text = post.body, modifier = Modifier.padding(10.dp), fontStyle = FontStyle.Italic)
        }
    }


    @Composable
    fun GetData(mainViewModel: MainViewModel) {
        when(val result = mainViewModel.response.value) {
            is ApiState.Success-> {
                LazyColumn{
                    items(result.data){response->
                        EachRow(post = response)
                    }
                }
            }
            is ApiState.Failure-> {
                 Text(text = "${result.msg}")
            }
            is ApiState.Loading-> {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator()
                }
            }
            ApiState.Empty->{
                Toast.makeText(this, "Empty State Call", Toast.LENGTH_SHORT).show()
            }
        }
    }
}