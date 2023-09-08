package com.example.navigationandpaging.ui.navigation.navgraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.navigation
import com.example.navigationandpaging.ui.screens.favorites.favoriteScreen
import com.example.navigationandpaging.ui.screens.home.homeScreen
import com.example.navigationandpaging.ui.screens.home.homeScreenNavRoute
import com.example.navigationandpaging.ui.screens.orders.orderScreen
import com.example.navigationandpaging.ui.screens.productdetail.navigateToProductDetailScreen
import com.example.navigationandpaging.ui.screens.profile.profileScreen

private const val homeNavGraphRoute = "homeNavGraphRoute"


fun NavController.navigateToHomeNavGraph(navOptions: NavOptions?=null) {
    navigate(route = homeNavGraphRoute, navOptions = navOptions)
}

fun NavGraphBuilder.homeNavGraph(navController: NavController){
    navigation(route = homeNavGraphRoute, startDestination = homeScreenNavRoute){
        homeScreen(
            onNavigateToDetailPage = { productId ->
                navController.navigateToProductDetailScreen(productId)
            }
        )
        orderScreen { }
        profileScreen { }
        favoriteScreen { }
    }
}