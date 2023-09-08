package com.example.navigationandpaging.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddMinusCartButton(
    modifier: Modifier = Modifier,
    qty: Int,
    onAddClick: () -> Unit,
    onMinusClick: () -> Unit
) {

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {

        IconCartButton(imageVector = Icons.Default.Remove) {
            onMinusClick()
        }
        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = qty.toString(), style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )
        )

        Spacer(modifier = Modifier.width(12.dp))

        IconCartButton(imageVector = Icons.Default.Add) {
            onAddClick()
        }
    }


}



@Composable
private fun IconCartButton(imageVector: ImageVector, onClick: () -> Unit) {
    Icon(
        imageVector = imageVector,
        contentDescription = "",
        modifier = Modifier
            .size(30.dp)
            .background(
                color = Color.LightGray.copy(0.5f),
                shape = MaterialTheme.shapes.small
            )
            .clip(
                shape = MaterialTheme.shapes.small
            )
            .clickable {
                onClick()
            }
            .padding(6.dp)
    )
}
