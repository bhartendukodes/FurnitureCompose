package com.example.navigationandpaging.ui.navigation.navgraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.navigation
import com.example.navigationandpaging.ui.screens.auth.emailLoginScreen
import com.example.navigationandpaging.ui.screens.auth.navigateToEmailLoginScreen
import com.example.navigationandpaging.ui.screens.auth.navigateToSignInLoginScreen
import com.example.navigationandpaging.ui.screens.auth.navigateToSignUpLoginScreen
import com.example.navigationandpaging.ui.screens.auth.otpVerifyScreen
import com.example.navigationandpaging.ui.screens.auth.signInNavRoute
import com.example.navigationandpaging.ui.screens.auth.signInScreen
import com.example.navigationandpaging.ui.screens.auth.signInWithEmail
import com.example.navigationandpaging.ui.screens.auth.signUpWithEmail
import com.example.navigationandpaging.ui.screens.home.homeScreenNavRoute

const val signInNavGraphRoute = "signInNavGraphRoute"

fun NavController.navigateToAuthentication(navOptions: NavOptions? = null) {
    navigate(route = signInNavGraphRoute, navOptions = navOptions)
}

fun NavGraphBuilder.signInNavGraph(navController: NavController) {

    navigation(route = signInNavGraphRoute, startDestination = signInNavRoute) {

        signInWithEmail(
            navigateToHome = {
                navController.navigate(route = homeScreenNavRoute){
                    popUpTo(signInNavGraphRoute){
                        inclusive = true
                    }
                }
            },
            navigateToSignUp = navController::navigateToSignUpLoginScreen,
            onBack = navController::navigateUp
        )

        signUpWithEmail(
            onBackPressed = navController::navigateUp,
            navigateToSignInScreen = {
                navController.navigateToSignInLoginScreen()
            }
        )

    }

}
