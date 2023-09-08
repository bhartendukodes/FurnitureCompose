package com.example.navigationandpaging.ui.navigation.bottomNavigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun MyBottomNavigation(items: List<BottomNavItem>, currentRoute: String?) {

    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 4.dp,
        contentColor = Color.Black
    ) {
        items.forEach { item ->
            val isSelected = currentRoute?.contains(item.title, ignoreCase = true) == true

            NavigationBarItem(
                alwaysShowLabel = false,
                selected = isSelected,
                onClick = {
                    item.onClick.invoke()
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.title)
                },
                label = {
                    Text(text = item.title)
                }
            )
        }
    }

}