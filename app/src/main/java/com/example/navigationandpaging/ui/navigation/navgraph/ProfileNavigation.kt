package com.example.navigationandpaging.ui.navigation.navgraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.navigationandpaging.ui.screens.profile.profileScreenNavRoute

private const val profileNavGraphRoute = "profileNavGraphRoute"

fun NavGraphBuilder.profileNavGraph(navController: NavController) {

    navigation(route = profileNavGraphRoute, startDestination = profileScreenNavRoute) {

    }
}