package com.example.navigationandpaging.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.navigationandpaging.R
import com.example.navigationandpaging.models.DummyData
import com.example.navigationandpaging.ui.components.ComposableTopAppBarWithTwoTitles
import com.example.navigationandpaging.ui.screens.components.ProductUi
import com.example.navigationandpaging.ui.theme.greyLight
import com.example.navigationandpaging.ui.theme.greyLightBG

const val homeScreenNavRoute = "homeScreenNavRoute"

fun NavController.navigateToHomeScreen(navOptions: NavOptions? = null) {
    navigate(route = homeScreenNavRoute, navOptions = navOptions)
}

fun NavGraphBuilder.homeScreen(onNavigateToDetailPage: (productId: String) -> Unit) {
    composable(route = homeScreenNavRoute) {
        HomeScreen(onNavigateToDetailPage = onNavigateToDetailPage)
    }
}

@Composable
fun HomeScreen(onNavigateToDetailPage: (productId: String) -> Unit) {

    var selectedFilter by remember {
        mutableStateOf(R.drawable.ic_star)
    }

    Scaffold(
        topBar = {
            ComposableTopAppBarWithTwoTitles(
                title1 = "Make Home",
                title2 = "Beautiful".uppercase(),
                navigationIcon = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            Icons.Rounded.Search,
                            contentDescription = null,
                            modifier = Modifier.padding(6.dp)
                        )
                    }
                }
            ) {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Rounded.Notifications, contentDescription = "shoppingCart")
                }
            }
        }
    ) { innerPadding ->

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            item(span = {
                GridItemSpan(2)
            }) {
                FilterSection(
                    items = DummyData.filterItems,
                    onSelect = {
                        selectedFilter = it
                    },
                    selectedFilter = selectedFilter
                )
            }

            items(items = DummyData.products, key = {
                it.name.plus((Int.MIN_VALUE..Int.MAX_VALUE).random())
            }) {
                ProductUi(
                    product = it,
                    onClick = {
                        onNavigateToDetailPage(it.name)
                    }
                )
            }

        }
    }
}


@Composable
fun FilterSection(items: List<Pair<Int, String>>, onSelect: (Int) -> Unit, selectedFilter: Int) {
    Row(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {

        items.forEachIndexed { indexed, item ->
            val isSelected = selectedFilter == item.first

            if (indexed == 0)
                Spacer(modifier = Modifier.width(16.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .clickable {
                        onSelect(item.first)
                    }
                    .padding(4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            color = if (isSelected) Color.Black else greyLightBG,
                            RoundedCornerShape(16.dp)
                        )
                        .size(44.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = item.first),
                        contentDescription = "",
                        contentScale = ContentScale.Inside,
                        modifier = Modifier
                            .size(28.dp),
                        colorFilter = ColorFilter.tint(color = if (isSelected) Color.White else Color.Black)
                    )
                }

                Spacer(Modifier.height(12.dp))

                Text(
                    text = item.second, style = MaterialTheme.typography.labelMedium.copy(
                        color = if (isSelected) Color.Black else greyLight
                    )
                )

            }

            Spacer(modifier = Modifier.width(16.dp))
        }

    }
}