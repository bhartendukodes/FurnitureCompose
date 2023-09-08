package com.example.navigationandpaging.ui.navigation.navgraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.navigationandpaging.ui.screens.orders.orderScreenNavRoute

private const val orderNavGraphRoute = "orderNavGraphRoute"

fun NavGraphBuilder.orderNavGraph(navController: NavController) {

    navigation(route = orderNavGraphRoute , startDestination = orderScreenNavRoute){

    }
}