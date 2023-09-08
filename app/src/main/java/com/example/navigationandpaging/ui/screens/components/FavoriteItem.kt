package com.example.navigationandpaging.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationandpaging.R
import com.example.navigationandpaging.models.fav.FavoriteItem

@Composable
fun FavoriteItem(
    onIconDelete: () -> Unit,
    favButtonIcon: () -> Unit,
    fav: FavoriteItem,
    isLastItem: Boolean,
) {

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 18.dp, vertical = 14.dp)
        .padding(end = 14.dp)){
        Row {
            Image(
                painter = painterResource(id = fav.img),
                contentDescription = "null",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(105.dp)
                    .width(100.dp)
                    .clip(shape = MaterialTheme.shapes.medium)
            )

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = fav.title,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = colorResource(id = R.color.grey),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = fav.amount,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Icon(
                painter = painterResource(id = R.drawable.ic_cross),
                contentDescription = "Remove",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onIconDelete() }
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_shopping_bag),
            contentDescription = "Increase Quantity",
            modifier = Modifier
                .size(28.dp)
                .clickable {
                    favButtonIcon()
                }
                .background(
                    color = Color.Gray.copy(0.2f),
                    shape = MaterialTheme.shapes.medium
                )
                .padding(6.dp)
                .align(Alignment.BottomEnd)
        )
    }

    if (!isLastItem) {
        Divider(
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(color = colorResource(id = R.color.divider_color_2).copy(0.3f)),
        )

    }
}