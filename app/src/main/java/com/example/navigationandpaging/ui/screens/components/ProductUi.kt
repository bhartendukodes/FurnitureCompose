package com.example.navigationandpaging.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.navigationandpaging.R
import com.example.navigationandpaging.models.products.Product

@Composable
fun ProductUi(product: Product, onClick: () -> Unit, modifier: Modifier = Modifier) {

    Column(modifier = modifier
        .fillMaxWidth()
        .clip(MaterialTheme.shapes.small)
        .clickable {
            onClick.invoke()
        }) {

        Spacer(Modifier.height(10.dp))

        Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {

            Image(
                painter = painterResource(id = product.image),
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.9f)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.ic_shopping_bag),
                contentDescription = "",
                modifier = Modifier
                    .padding(end = 12.dp, bottom = 6.dp)
                    .size(30.dp)
                    .clip(MaterialTheme.shapes.small)
                    .background(
                        color = Color.DarkGray.copy(0.3f),
                        shape = MaterialTheme.shapes.medium

                    )
                    .padding(6.dp)
                    .align(Alignment.BottomEnd)
                    .clickable {

                    }
            )

        }

        Spacer(Modifier.height(10.dp))

        Text(
            text = product.name,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Spacer(Modifier.height(6.dp))

        Text(
            text = product.price,
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold),
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Spacer(Modifier.height(10.dp))

    }

}