package com.example.navigationandpaging.ui.screens.auth

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

private const val ARG_MOBILE_NUMBER = "{mobileNumber}"
private const val otpVerifyScreenNavRoute = "otpVerifyScreenNavRoute/$ARG_MOBILE_NUMBER"

fun NavController.navigateToVerifyOtpScreen(mobileNumber: String, navOptions: NavOptions? = null) {
    this.navigate(route = otpVerifyScreenNavRoute.replace(ARG_MOBILE_NUMBER, mobileNumber))
}

fun NavGraphBuilder.otpVerifyScreen(onOtpVerified: () -> Unit, onBackPressed: () -> Unit) {
    composable(
        route = otpVerifyScreenNavRoute,
        arguments = listOf(navArgument(ARG_MOBILE_NUMBER) {
            this.type = NavType.StringType
        })
    ) {
        OtpVerifyScreen(onOtpVerified = onOtpVerified, onBackPressed = onBackPressed)
    }
}


@Composable
fun OtpVerifyScreen(onOtpVerified: () -> Unit, onBackPressed: () -> Unit) {


}