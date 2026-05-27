package com.cibertec.das.one.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.cibertec.das.one.detail.DetailScreen
import com.cibertec.das.one.home.HomeScreen
import com.cibertec.das.one.login.LoginScreen
import com.cibertec.das.one.routes.Routes
import com.cibertec.das.one.splash.SplashScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {

    val navController = rememberNavController()

    Scaffold { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = Routes.SPLASH,
            modifier = Modifier.padding(paddingValues)
        ) {

            composable(Routes.SPLASH) {
                SplashScreen(navController)
            }

            composable(Routes.LOGIN) {
                LoginScreen(navController)
            }

            composable(Routes.HOME) {
                HomeScreen(navController)
            }

            composable(
                route = Routes.DETAIL,
                arguments = listOf(
                    navArgument("placeId") { type = NavType.IntType }
                )
            ) { backStackEntry ->
                val placeId = backStackEntry.arguments?.getInt("placeId") ?: 0
                DetailScreen(navController = navController, placeId = placeId)
            }
        }
    }
}
