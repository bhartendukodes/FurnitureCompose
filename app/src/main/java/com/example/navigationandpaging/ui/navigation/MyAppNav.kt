package com.example.navigationandpaging.ui.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.BookmarkBorder
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navOptions
import com.example.navigationandpaging.ui.navigation.bottomNavigation.BottomNavItem
import com.example.navigationandpaging.ui.navigation.bottomNavigation.MyBottomNavigation
import com.example.navigationandpaging.ui.navigation.navgraph.homeNavGraph
import com.example.navigationandpaging.ui.navigation.navgraph.navigateToAuthentication
import com.example.navigationandpaging.ui.navigation.navgraph.navigateToHomeNavGraph
import com.example.navigationandpaging.ui.navigation.navgraph.productNavGraph
import com.example.navigationandpaging.ui.navigation.navgraph.signInNavGraph
import com.example.navigationandpaging.ui.navigation.navgraph.signInNavGraphRoute
import com.example.navigationandpaging.ui.screens.auth.signInWithEmail
import com.example.navigationandpaging.ui.screens.favorites.favoriteScreenNavRoute
import com.example.navigationandpaging.ui.screens.favorites.navigateToFavoriteScreen
import com.example.navigationandpaging.ui.screens.home.homeScreenNavRoute
import com.example.navigationandpaging.ui.screens.home.navigateToHomeScreen
import com.example.navigationandpaging.ui.screens.orders.navigateToOrderScreen
import com.example.navigationandpaging.ui.screens.orders.orderScreenNavRoute
import com.example.navigationandpaging.ui.screens.profile.navigateToProfileScreen
import com.example.navigationandpaging.ui.screens.profile.profileScreenNavRoute
import com.example.navigationandpaging.ui.screens.splash.splashNavRoute
import com.example.navigationandpaging.ui.screens.splash.splashScreen

@Composable
fun MyAppNav(navHostController: NavHostController) {

    val currentDestination by
    navHostController.currentBackStackEntryAsState()

    fun getNavOption() = navOptions {
        popUpTo(  homeScreenNavRoute) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }

    val showBottomNav = when (currentDestination?.destination?.route) {
        homeScreenNavRoute, orderScreenNavRoute, favoriteScreenNavRoute, profileScreenNavRoute -> true
        else -> false
    }

    val bottomNavItems by remember {
        mutableStateOf(
            listOf(
                BottomNavItem(
                    title = "Home",
                    icon = Icons.Rounded.Home,
                    onClick = {
                        navHostController.navigateToHomeScreen(getNavOption())
                    }),
                BottomNavItem(
                    title = "Order",
                    icon = Icons.Rounded.ShoppingCart,
                    onClick = {
                        navHostController.navigateToOrderScreen(getNavOption())
                    }),
                BottomNavItem(
                    title = "Favorite",
                    icon = Icons.Rounded.BookmarkBorder,
                    onClick = {
                        navHostController.navigateToFavoriteScreen(getNavOption())
                    }),
                BottomNavItem(
                    title = "Profile",
                    icon = Icons.Rounded.Person,
                    onClick = {
                        navHostController.navigateToProfileScreen(getNavOption())
                    }),
            )
        )
    }

    Column(
        modifier = Modifier
            .animateContentSize()
            .fillMaxSize()
    ) {

        NavHost(
            navController = navHostController,
            startDestination = splashNavRoute,
            modifier = Modifier.weight(1f)
        ) {

            splashScreen {
                navHostController.navigateToAuthentication(
                    navOptions = navOptions {
                        popUpTo(route = splashNavRoute){
                            inclusive = true
                            saveState = false
                        }
                    }
                )
            }

            signInNavGraph(navController = navHostController)

            homeNavGraph(navController = navHostController)

            productNavGraph(navController = navHostController)

        }

        AnimatedVisibility(
            visible = showBottomNav,
        ) {
            MyBottomNavigation(
                items = bottomNavItems,
                currentRoute = currentDestination?.destination?.route
            )
        }

    }


}