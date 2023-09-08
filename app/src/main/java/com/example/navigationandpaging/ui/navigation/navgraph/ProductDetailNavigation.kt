package com.example.navigationandpaging.ui.navigation.navgraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.navigationandpaging.ui.screens.productdetail.productDetailNavRoute
import com.example.navigationandpaging.ui.screens.productdetail.productDetailScreen

private const val productNavGraphRoute = "productNavGraphRoute"

fun NavGraphBuilder.productNavGraph(navController: NavController) {

    navigation(route = productNavGraphRoute , startDestination = productDetailNavRoute){
        productDetailScreen {  }
    }
}