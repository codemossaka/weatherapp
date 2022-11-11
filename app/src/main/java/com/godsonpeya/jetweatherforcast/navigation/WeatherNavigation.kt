package com.godsonpeya.jetweatherforcast.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.godsonpeya.jetweatherforcast.screens.main.MainScreen
import com.godsonpeya.jetweatherforcast.screens.WeatherSplashScreen
import com.godsonpeya.jetweatherforcast.screens.main.MainViewModel
import com.godsonpeya.jetweatherforcast.screens.search.SearchScreen

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = WeatherScreens.SplashScreen.name
    ) {
        composable(WeatherScreens.SplashScreen.name){
            WeatherSplashScreen(navController = navController)
        }
        composable(WeatherScreens.MainScreen.name){
            val mainViewModel = hiltViewModel<MainViewModel>()
            MainScreen(navController = navController, viewModel=mainViewModel)
        }
        composable(WeatherScreens.SearchScreen.name){
            SearchScreen(navController = navController)
        }
    }
}