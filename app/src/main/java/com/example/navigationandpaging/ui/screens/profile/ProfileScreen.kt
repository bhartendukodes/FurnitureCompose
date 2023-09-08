package com.example.navigationandpaging.ui.screens.profile

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.navigationandpaging.R
import com.example.navigationandpaging.models.DummyData
import com.example.navigationandpaging.models.products.Product
import com.example.navigationandpaging.models.profile.Profile
import com.example.navigationandpaging.ui.components.ProfileAppBar

const val profileScreenNavRoute = "profileScreenNavRoute"

fun NavController.navigateToProfileScreen(navOptions: NavOptions? = null) {
    navigate(route = profileScreenNavRoute, navOptions = navOptions)
}

fun NavGraphBuilder.profileScreen(onBackPressed: () -> Unit) {
    composable(route = profileScreenNavRoute) {
        ProfileScreen(onBackPressed = onBackPressed)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(onBackPressed: () -> Unit) {
    Scaffold(
        topBar = {
            ProfileAppBar(
                title = "Profile",
                navigationIcon = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = null,
                            modifier = Modifier.padding(6.dp),
                            tint = Color.Black
                        )
                    }
                },
            )
            {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        Icons.Filled.Logout,
                        contentDescription = "shoppingCart",
                        tint = Color.Black
                    )
                }
            }
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    ProfileSection()
                }


               
                items(items = DummyData.profileData) {
                    SelectingCard(
                        profile = it,
                        onClick = {

                        }
                    )
                }


            }
        }
    }
}

@Composable
fun ProfileSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 14.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_users_profile),
            contentDescription = "users",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(80.dp)
                .clip(shape = RoundedCornerShape(50.dp))
        )

        Spacer(modifier = Modifier.width(20.dp))

        Column(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = stringResource(id = R.string.bruno_pham),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.Black.copy(0.8f),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = stringResource(id = R.string.bruno_pham_email),
                style = MaterialTheme.typography.labelMedium.copy(
                    color = Color.LightGray,
                    fontSize = 16.sp
                )
            )
        }
    }
}


@Composable
fun SelectingCard(profile: Profile, onClick: () -> Unit) {

    Spacer(modifier = Modifier.height(16.dp))

    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        border = null,
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Box {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = profile.title,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = colorResource(id = R.color.black),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = profile.description,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = colorResource(id = R.color.grey),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }

                Spacer(modifier = Modifier.weight(1f)) // This spacer pushes the icon to the end
                Icon(
                    modifier = Modifier
                        .size(20.dp),
                    painter = painterResource(id = R.drawable.ic_arrow_forward),
                    contentDescription = "arrow"
                )
            }
        }
    }
}




