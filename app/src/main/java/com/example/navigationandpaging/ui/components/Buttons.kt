package com.example.navigationandpaging.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .background(color = Color.Black, shape = MaterialTheme.shapes.medium)
            .clip(MaterialTheme.shapes.medium)
            .clickable {
                onClick.invoke()
            }
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = text, style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.White
            )
        )

    }
}
@Composable
@Preview(showBackground = true)
fun MyButtonPreview() {
    MyButton(text = "My Button") {

    }
}