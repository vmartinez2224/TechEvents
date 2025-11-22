package com.techevents.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.techevents.CatalogScreen
import com.techevents.DetailScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = CatalogScreen
    ) {
        composable<CatalogScreen> {
            CatalogScreen { item ->
                navController.navigate(
                    DetailScreen(
                        title = item.title,
                        description = item.description
                    )
                )
            }
        }
        composable<DetailScreen> { entry ->
            val args = entry.toRoute<DetailScreen>()
            DetailScreen(
                title = args.title,
                description = args.description,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
