package com.example.navigationandpaging.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigationandpaging.R
import com.example.navigationandpaging.ui.components.ComposableOutlinedPasswordField
import com.example.navigationandpaging.ui.components.MyOutlinedTextField

private const val signUpLoginNavRoute = "signUpLoginNavRoute"

fun NavController.navigateToSignUpLoginScreen() {
    this.navigate(signUpLoginNavRoute)
}

fun NavGraphBuilder.signUpWithEmail(
    navigateToSignInScreen: () -> Unit,
    onBackPressed: () -> Unit
) {

    composable(route = signUpLoginNavRoute) {
        SignUpWithEmail(
            navigateToSignInScreen = navigateToSignInScreen,
            onBackPressed = onBackPressed
        )
    }

}

@Composable
fun SignUpWithEmail(navigateToSignInScreen: () -> Unit, onBackPressed: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp, top = 52.dp)
            .fillMaxSize()

    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Divider(
                thickness = 1.dp,
                color = colorResource(id = R.color.divider_color),
                modifier = Modifier.width(120.dp)
            )

            Image(painter = painterResource(id = R.drawable.group_login), contentDescription = null)

            Divider(
                thickness = 1.dp,
                color = colorResource(id = R.color.divider_color),
                modifier = Modifier.width(120.dp)
            )
        }

        Column(
            modifier = Modifier.padding(
                top = 28.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 20.dp
            )
        ) {
            Text(
                text = stringResource(id = R.string.welcome),
                fontFamily = FontFamily(Font(R.font.bold)),
                color = colorResource(id = R.color.black),
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            SignUpCardScreen(navigateToSignInScreen = navigateToSignInScreen)
        }
    }
}

@Composable
fun SignUpCardScreen(navigateToSignInScreen: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
        ),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.white)
        )
    ) {
        Column(
            modifier = Modifier.padding(
                top = 30.dp, bottom = 20.dp, start = 16.dp, end = 16.dp
            )
        ) {
            var name by remember {
                mutableStateOf("")
            }
            MyOutlinedTextField(value = name, label = "Name", onValueChange = { name = it })

            Spacer(modifier = Modifier.height(20.dp))


            var email by mutableStateOf("")

            MyOutlinedTextField(value = email, onValueChange = { email = it }, label = "Email")

            Spacer(modifier = Modifier.height(20.dp))

            var password by mutableStateOf("")
            val isPasswordHidden by remember { mutableStateOf(true) }

            ComposableOutlinedPasswordField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = { password = it },
                label = { Text("Enter password") },
                isPasswordHidden = isPasswordHidden,
                backgroundColor = Color.White,
                togglePasswordVisibilityIcon = if (isPasswordHidden) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                togglePasswordContentDescription = if (isPasswordHidden) "Show password" else "Hide password"
            )

            Spacer(modifier = Modifier.height(20.dp))

            var confirmPassword by mutableStateOf("")
            val isPasswordHiddens by remember { mutableStateOf(true) }


            ComposableOutlinedPasswordField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Confirm Password") },
                isPasswordHidden = isPasswordHiddens,
                backgroundColor = Color.White,
                togglePasswordVisibilityIcon = if (isPasswordHiddens) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                togglePasswordContentDescription = if (isPasswordHiddens) "Show password" else "Hide password",
                keyboardOptions = KeyboardOptions.Default,
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = { navigateToSignInScreen.invoke() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White,
                ),
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    text = "Sign Up",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(8.dp)
                ).toString()
            }


            Spacer(modifier = Modifier.height(30.dp))


            val annotatedText = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = colorResource(id = R.color.grey),
                        fontFamily = FontFamily(Font(R.font.medium))
                    )
                ) {
                    append("Already have account? ")
                }
                pushStringAnnotation(
                    tag = "URL",
                    annotation = "https://developer.android.com"
                )
                withStyle(
                    style = SpanStyle(
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("SIGN IN")
                }
                pop()
            }
            ClickableText(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navigateToSignInScreen.invoke()
                    },
                text = annotatedText,
                style = androidx.compose.material.MaterialTheme.typography.body1,
                onClick = { offset ->
                    // We check if there is an *URL* annotation attached to the text
                    // at the clicked position
                    annotatedText.getStringAnnotations(
                        tag = "URL",
                        start = offset,
                        end = offset
                    )
                        .firstOrNull()?.let { annotation ->

                        }
                }
            )
        }
    }
}


