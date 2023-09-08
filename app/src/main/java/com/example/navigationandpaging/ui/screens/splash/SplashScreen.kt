package com.example.navigationandpaging.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigationandpaging.R
import com.example.navigationandpaging.ui.theme.greyLight
import kotlinx.coroutines.delay

const val splashNavRoute = "splashNavRoute"

fun NavGraphBuilder.splashScreen(onSplashFinished: () -> Unit) {
    composable(route = splashNavRoute) {
        SplashScreen(onSplashFinished)
    }
}


@Composable
private fun SplashScreen(onSplashFinished: () -> Unit) {

    LaunchedEffect(key1 = Unit, block = {
        delay(3000)
        onSplashFinished.invoke()
    })

    Box(
        modifier = Modifier
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash_img),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 58.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                modifier = Modifier.padding(start = 14.dp),
                text = stringResource(id = R.string.make_your),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.DarkGray.copy(0.6f),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                modifier = Modifier.padding(start = 14.dp, end = 14.dp),
                text = stringResource(id = R.string.home_beautiful),
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.Black,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                modifier = Modifier.padding(start = 54.dp, end = 14.dp),
                text = stringResource(id = R.string.splash_quotes),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.DarkGray.copy(0.5f),
                    fontSize = 16.sp,
                )
            )
        }
    }
}