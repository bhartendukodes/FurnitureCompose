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

    // Current route ko track karne ke liye state variable. Yeh humein batayega ki user app mein kahan par hai.
    val currentDestination by navHostController.currentBackStackEntryAsState()

    // Navigation options ko set karne ke liye function. Yeh navigation behavior ko customize karta hai.
    fun getNavOption() = navOptions {
        // User jab navigate karta hai, to yeh define karta hai ki app ko kis screen pe le jana hai.
        popUpTo(homeScreenNavRoute) {
            saveState = true // Isse state save ho jayegi jab user navigate karta hai.
        }
        launchSingleTop = true // Yeh ensure karta hai ki ek hi instance run ho agar top pe already hai to.
        restoreState = true // Navigate karne par saved state ko restore karta hai.
    }

    // Bottom navigation bar ko show karne ya na karne ka decision yahaan hota hai, based on current route.
    val showBottomNav = when (currentDestination?.destination?.route) {
        // Agar current route inmein se koi bhi hai to true return karega, matlab bottom nav show karega.
        homeScreenNavRoute, orderScreenNavRoute, favoriteScreenNavRoute, profileScreenNavRoute -> true
        else -> false // Agar koi aur route hai to false return karega, matlab bottom nav nahi dikhayega.
    }

    // Bottom navigation items ki list. Yeh mutable state of hai takki dynamically change ho sake.
    val bottomNavItems by remember {
        mutableStateOf(
            listOf(
                BottomNavItem(
                    title = "Home",
                    icon = Icons.Rounded.Home,
                    onClick = {
                        // Home screen par navigate karta hai jab user home icon par click karta hai.
                        navHostController.navigateToHomeScreen(getNavOption())
                    }),
                BottomNavItem(
                    title = "Order",
                    icon = Icons.Rounded.ShoppingCart,
                    onClick = {
                        // Order screen par navigate karta hai jab user order icon par click karta hai.
                        navHostController.navigateToOrderScreen(getNavOption())
                    }),
                BottomNavItem(
                    title = "Favorite",
                    icon = Icons.Rounded.BookmarkBorder,
                    onClick = {
                        // Favorite screen par navigate karta hai jab user favorite icon par click karta hai.
                        navHostController.navigateToFavoriteScreen(getNavOption())
                    }),
                BottomNavItem(
                    title = "Profile",
                    icon = Icons.Rounded.Person,
                    onClick = {
                        // Profile screen par navigate karta hai jab user profile icon par click karta hai.
                        navHostController.navigateToProfileScreen(getNavOption())
                    }),
            )
        )
    }

    // Yahaan par UI layout define kiya gaya hai.
    Column(
        modifier = Modifier
            .animateContentSize() // Content size change hone par animation.
            .fillMaxSize() // Column ko parent ki maximum size tak fill karega.
    ) {
        // NavHost jo navigation graphs ko host karta hai. Yeh app navigation ko manage karta hai.
        NavHost(
            navController = navHostController, // Navigation controller.
            startDestination = splashNavRoute, // Starting destination set karta hai.
            modifier = Modifier.weight(1f) // Takes up all available space minus the space taken by other components.
        ) {
            splashScreen {
                // Splash screen ke baad authentication screen par navigate karne ka setup.
                navHostController.navigateToAuthentication(
                    navOptions = navOptions {
                        popUpTo(route = splashNavRoute){
                            inclusive = true // Splash screen ko back stack se hata deta hai.
                            saveState = false // Splash screen ka state save nahi karta.
                        }
                    }
                )
            }

            // SignIn, Home, Product navigation graphs ko yahaan include kiya gaya hai.
            signInNavGraph(navController = navHostController)
            homeNavGraph(navController = navHostController)
            productNavGraph(navController = navHostController)
        }

        // Bottom navigation bar ko show karne ya na karne ka logic yahaan implement kiya gaya hai.
        AnimatedVisibility(
            visible = showBottomNav, // Yeh decide karta hai ki bottom nav dikhana hai ya nahi.
        ) {
            // Custom bottom navigation bar component, jismein items aur current route pass kiya gaya hai.
            MyBottomNavigation(
                items = bottomNavItems,
                currentRoute = currentDestination?.destination?.route
            )
        }
    }
}