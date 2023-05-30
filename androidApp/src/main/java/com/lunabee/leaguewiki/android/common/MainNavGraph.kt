package com.lunabee.leaguewiki.android.common

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lunabee.leaguewiki.android.feature.detail.DetailDestination
import com.lunabee.leaguewiki.android.feature.detail.DetailRoute
import com.lunabee.leaguewiki.android.feature.home.HomeDestination
import com.lunabee.leaguewiki.android.feature.home.HomeRoute

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
            HomeRoute(
                navigateToChampionDetail = {
                    navController.navigate(DetailDestination.getRoute(it))
                }
            )
        }

        composable(
            route = DetailDestination.route,
            arguments = listOf(
                navArgument(DetailDestination.ChampionIdArgument) {
                    type = NavType.StringType
                    nullable = false
                },
            ),
        ) {
            DetailRoute(
                navigateBack = { navController.popBackStack() }
            )
        }
    }
}