package com.lunabee.leaguewiki.android.common

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lunabee.leaguewiki.android.feature.HomeDestination
import com.lunabee.leaguewiki.android.feature.HomeRoute

@Composable
fun MainNavGraph() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeDestination.route
    ) {
        composable(
            route = HomeDestination.route
        ) {
            HomeRoute()
        }
    }
}