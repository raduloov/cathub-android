package com.example.cathub.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
            FeedScreen(navController)
        }
        composable(route = BottomBarScreens.Profile.route) {
            FeedScreen(navController)
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
        selectedIcon = Icons.Filled.Star,
        unselectedIcon = Icons.Outlined.Star
    )

    object Profile: BottomBarScreens(
        route = "profile",
        title = "Profile",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person
    )
}