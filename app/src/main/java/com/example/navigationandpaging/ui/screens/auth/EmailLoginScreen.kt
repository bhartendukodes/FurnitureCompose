package com.example.navigationandpaging.ui.screens.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.navigationandpaging.ui.components.MyTopAppBar

private const val emailLoginNavRoute = "emailLoginNavRoute"


fun NavController.navigateToEmailLoginScreen(navOption: NavOptions? = null) {
    this.navigate(emailLoginNavRoute, navOptions = navOption)
}

fun NavGraphBuilder.emailLoginScreen(onEmailVerified:() -> Unit, onBackPressed:() -> Unit){
    composable(route = emailLoginNavRoute){
        EmailLoginScreen(onEmailVerified = onEmailVerified, onBackPressed = onBackPressed)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EmailLoginScreen(onEmailVerified: () -> Unit, onBackPressed: () -> Unit){

}