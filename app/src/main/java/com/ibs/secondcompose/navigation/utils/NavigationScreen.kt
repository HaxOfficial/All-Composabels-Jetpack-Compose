package com.ibs.secondcompose.navigation.utils

sealed class NavigationScreen(val route:String){
    object FirstScreen : NavigationScreen("firstScreen")
    object SecondScreen : NavigationScreen("{data}/secondScreen"){
        fun createRoute(data:String) = "$data/secondScreen"
    }
    object ThirdScreen : NavigationScreen("thirdScreen")
}
