package com.example.composenavigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation () {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.checkin, builder = {
        composable(Routes.checkin){
            Checkin(navController)
        }
        composable(Routes.checkinnextstep){
            Checkinnextstep(navController)
        }
    })
}