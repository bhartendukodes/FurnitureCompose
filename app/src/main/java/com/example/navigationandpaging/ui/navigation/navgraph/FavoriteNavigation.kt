package com.example.navigationandpaging.ui.navigation.navgraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.navigationandpaging.ui.screens.favorites.favoriteScreen
import com.example.navigationandpaging.ui.screens.favorites.favoriteScreenNavRoute


private const val favoriteNavGraphRoute = "favoriteNavGraphRoute"

fun NavGraphBuilder.favoriteNavGraph(navController: NavController) {

    navigation(route = favoriteNavGraphRoute , startDestination = favoriteScreenNavRoute){

        favoriteScreen {  }
    }
}