package com.example.navigationandpaging.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun MyOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) }
    )
}


@Composable
fun ComposableOutlinedPasswordField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable () -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable (() -> Unit)? = null,
    isPasswordHidden: Boolean = false,
    togglePasswordVisibilityIcon: ImageVector = if (isPasswordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
    togglePasswordContentDescription: String = if (isPasswordHidden) "Show password" else "Hide password",
    backgroundColor: Color = Color.White
) {
    var passwordHidden by remember { mutableStateOf(isPasswordHidden) }
    var password by remember { mutableStateOf(value) }
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .background(color = backgroundColor),
        value = password,
        onValueChange = {
            password = it
            onValueChange(it)
        },
        label = label,
        visualTransformation = if (passwordHidden) PasswordVisualTransformation() else visualTransformation,
        keyboardOptions = keyboardOptions.copy(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        trailingIcon = {
            trailingIcon?.invoke()
            if (trailingIcon == null) {
                IconButton(onClick = { passwordHidden = !passwordHidden }) {
                    Icon(
                        imageVector = togglePasswordVisibilityIcon,
                        contentDescription = togglePasswordContentDescription
                    )
                }
            }
        }
    )
}


