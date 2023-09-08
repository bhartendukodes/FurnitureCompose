package com.example.navigationandpaging.ui.screens.orders

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.navigationandpaging.models.DummyData
import com.example.navigationandpaging.ui.components.MyButton
import com.example.navigationandpaging.ui.components.ProfileAppBar
import com.example.navigationandpaging.ui.screens.components.CartItem

const val orderScreenNavRoute = "orderScreenNavRoute"

fun NavController.navigateToOrderScreen(navOptions: NavOptions? = null) {
    navigate(route = orderScreenNavRoute, navOptions = navOptions)
}

fun NavGraphBuilder.orderScreen(onBackPressed: () -> Unit) {
    composable(route = orderScreenNavRoute) {
        OrderScreen(onBackPressed = onBackPressed)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen(onBackPressed: () -> Unit) {
    Scaffold(
        topBar = {
            ProfileAppBar(title = "My Cart", navigationIcon = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        Icons.Outlined.ArrowBack,
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
            })
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(items = DummyData.cartItems) {
                    CartItem(
                        onIconDelete = { /*TODO*/ },
                        cart = it,
                        isLastItem = it == DummyData.cartItems.last()
                    )
                }
            }

            Column(
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Row(
                    modifier = Modifier
                        .background(Color.White)
                        .padding(horizontal = 18.dp)
                        .clip(MaterialTheme.shapes.large)
                ) {
                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        text = "Total: ", style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 18.sp,
                            color = Color.Gray,
                            shadow = Shadow(Color.Gray),
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "$ 95.00", style = MaterialTheme.typography.bodyLarge.copy(
                            color = Color.Black,
                            fontSize = 18.sp,
                            shadow = Shadow(Color.Black),
                            fontWeight = FontWeight.Bold
                        )
                    )

                }

                MyButton(
                    text = "Check out",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp)
                        .height(60.dp)
                ) {

                }
            }
        }
    }
}
