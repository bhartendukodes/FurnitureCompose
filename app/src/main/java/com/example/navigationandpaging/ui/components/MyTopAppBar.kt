package com.example.navigationandpaging.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationandpaging.R
import com.example.navigationandpaging.ui.theme.greyLight
import com.example.navigationandpaging.ui.theme.md_theme_dark_shadow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(title: String? = null, onBackPressed: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = title ?: "")
        },
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(title: String? = null) {
    TopAppBar(
        title = {
            Text(text = title ?: "")
        },

        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileAppBar(
    title: String,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {}
) {
    if (navigationIcon != null) {
        TopAppBar(
            title = {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = title,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = md_theme_dark_shadow,
                            fontSize = 18.sp,
                            lineHeight = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
            },
            navigationIcon = navigationIcon,
            actions = actions
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposableTopAppBarWithTwoTitles(
    title1: String,
    title2: String,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {}
) {
    if (navigationIcon != null) {
        TopAppBar(
            title = {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = title1,
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = greyLight,
                            fontSize = 14.sp,
                            lineHeight = 18.sp
                        ),
                    )

                    Text(
                        text = title2,
                        style = MaterialTheme.typography.titleLarge.copy(
                            color = Color.Black,
                            lineHeight = 25.sp,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    )
                }
            },
            navigationIcon = navigationIcon,
            actions = actions
        )
    }
}