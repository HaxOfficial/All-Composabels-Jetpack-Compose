package com.ibs.secondcompose.tabview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.ibs.secondcompose.ui.theme.SecondComposeTheme
import kotlinx.coroutines.launch

class TabView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondComposeTheme {
                Surface {
                    TabViewUI()
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabViewUI() {

    val pageState = rememberPagerState()
    val currentPage = pageState.currentPage
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        TabRow(
            selectedTabIndex = currentPage,
            backgroundColor = Color.Green,
            divider = {
                TabRowDefaults.Divider(
                    color = Color.Yellow,
                    thickness = 2.dp,
                )
            },
//            indicator = {
//                TabRowDefaults.Indicator(
//                    color = Color.Red,
//                    height = 2.dp
//                )
//            }
        ) {
            tabList.forEachIndexed { index, tabData ->
                Tab(selected = currentPage == index, onClick = {
                    scope.launch {
                        pageState.animateScrollToPage(index)
                    }
                },
                modifier = Modifier.padding(20.dp)
                    ) {
                    Text(text = tabList[index].tab)
                }
            }
        }

        HorizontalPager(count = tabList.size, state = pageState, modifier = Modifier.fillMaxSize()) { index ->
            Text(text = tabList[index].desc)
        }

    }

}

data class TabData(
    val tab:String,
    val desc:String
)

val tabList = listOf(
    TabData(
        "Home",
        "This is Home Page"
    ),

    TabData(
        "Images",
        "This is Images"
    ),

    TabData(
        "Video",
        "This is Videos"
    ),
)






