package com.example.navigationandpaging.ui.screens.favorites

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.navigationandpaging.models.DummyData
import com.example.navigationandpaging.ui.components.MyButton
import com.example.navigationandpaging.ui.components.ProfileAppBar
import com.example.navigationandpaging.ui.screens.components.FavoriteItem

const val favoriteScreenNavRoute = "FavoriteScreenNavRoute"

fun NavController.navigateToFavoriteScreen(navOptions: NavOptions? = null) {
    navigate(route = favoriteScreenNavRoute, navOptions = navOptions)
}

fun NavGraphBuilder.favoriteScreen(onBackPressed: () -> Unit) {
    composable(route = favoriteScreenNavRoute) {
        FavoriteScreen(onBackPressed = onBackPressed)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreen(onBackPressed: () -> Unit) {
    Scaffold(
        topBar = {
            ProfileAppBar(title = "Favorite", navigationIcon = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        Icons.Outlined.Search,
                        contentDescription = null,
                        modifier = Modifier.padding(6.dp),
                        tint = Color.Black
                    )
                }
            },
                actions = {
                    Icon(
                        Icons.Outlined.ShoppingCart,
                        contentDescription = null,
                        modifier = Modifier.padding(6.dp),
                        tint = Color.Black
                    )
                }
            )
        }
    ) {
        Box(modifier = Modifier
            .padding(it)
            .fillMaxSize()) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(items = DummyData.favoriteItems) {
                    FavoriteItem(
                        onIconDelete = { /*TODO*/ },
                        favButtonIcon = { /*TODO*/ },
                        fav = it,
                        isLastItem = it == DummyData.favoriteItems.last()
                    )
                }

                item{
                    Spacer(modifier = Modifier.height(80.dp))
                }
            }


            MyButton(text = "Add All To My Cart", modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .align(Alignment.BottomEnd)
                .height(60.dp)) {

            }
        }
    }
}