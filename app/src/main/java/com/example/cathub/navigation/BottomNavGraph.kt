package com.example.cathub.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.cathub.ui.screens.details.DetailsScreen
import com.example.cathub.ui.screens.favorites.FavoritesScreen
import com.example.cathub.ui.screens.favorites.FavoritesViewModel
import com.example.cathub.ui.screens.feed.FeedScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreens.Feed.route
    ) {
        composable(route = BottomBarScreens.Feed.route) {
            FeedScreen(navController)
        }
        composable(route = BottomBarScreens.Discover.route) {
            FavoritesScreen(navController)
        }
        composable(
            route = Screens.Details.route + "/{breed}/{image}/{description}",
            arguments = listOf(
                navArgument("breed") {
                    type = NavType.StringType
                },
                navArgument("image") {
                    type = NavType.StringType
                },
                navArgument("description") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            DetailsScreen(
                navController,
                breed = entry.arguments?.getString("breed")!!,
                image = entry.arguments?.getString("image")!!,
                description = entry.arguments?.getString("description")!!
            )
        }
    }
}

sealed class BottomBarScreens(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    object Feed: BottomBarScreens(
        route = "feed",
        title = "Feed",
        selectedIcon = Icons.Filled.Feed,
        unselectedIcon = Icons.Outlined.Feed
    )

    object Discover: BottomBarScreens(
        route = "favorites",
        title = "Favorites",
        selectedIcon = Icons.Filled.Favorite,
        unselectedIcon = Icons.Outlined.Favorite
    )
}

sealed class Screens(
    val route: String
) {
    object Details: Screens(
        route = "details"
    )

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}