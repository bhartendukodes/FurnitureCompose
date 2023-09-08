package com.example.navigationandpaging.ui.screens.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.navigationandpaging.models.cart.CartItem
import com.example.navigationandpaging.models.fav.FavoriteItem
import com.example.navigationandpaging.ui.components.AddMinusCartButton

@Composable
fun CartItem(
    onIconDelete: () -> Unit,
    cart: CartItem,
    isLastItem: Boolean
) {

    var qty by remember {
        mutableStateOf(0)
    }
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp, vertical = 14.dp)
    ) {
        Image(
            painter = painterResource(id = cart.img),
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
                text = cart.title,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = colorResource(id = R.color.grey),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = cart.amount,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(14.dp))
            AddMinusCartButton(qty = qty,
                onAddClick = { qty += 1 },
                onMinusClick = {
                    if (qty > 0)
                        qty -= 1
                })
        }

        Column() {

            Icon(
                painter = painterResource(id = R.drawable.ic_cross),
                contentDescription = "Remove",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onIconDelete() }
            )
        }
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