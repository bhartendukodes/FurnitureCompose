package com.example.navigationandpaging.ui.screens.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigationandpaging.R
import com.example.navigationandpaging.ui.components.MyOutlinedTextField

const val signInNavRoute = "signInNavRoute"

fun NavController.navigateToSignInLoginScreen() {
    this.navigate(route = signInNavRoute)
}


fun NavGraphBuilder.signInWithEmail(
    navigateToSignUp: () -> Unit, navigateToHome: () -> Unit, onBack: () -> Unit
) {
    composable(route = signInNavRoute) {
        signInScreen(
            navigateToHome = navigateToHome,
            navigateToSignUp = navigateToSignUp
        )
    }
}


@Composable
fun signInScreen(
    navigateToHome: () -> Unit,
    navigateToSignUp: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(start = 14.dp, end = 14.dp, top = 52.dp)
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


        Column(modifier = Modifier.padding(top = 28.dp, start = 20.dp)) {
            Text(
                text = stringResource(id = R.string.hello),
                fontFamily = FontFamily(Font(R.font.regular)),
                color = colorResource(id = R.color.grey),
                fontSize = 28.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(id = R.string.back),
                style = MaterialTheme.typography.bodySmall.copy(

                ),
                color = colorResource(id = R.color.black),
                fontSize = 26.sp
            )
        }
        Spacer(modifier = Modifier.height(26.dp))

        Column(modifier = Modifier.padding(end = 10.dp, start = 10.dp)) {

            inputFieldsUi(navigateToHome = navigateToHome, navigateToSignUp = navigateToSignUp)

        }

    }
}

@Composable
fun inputFieldsUi(navigateToHome: () -> Unit, navigateToSignUp: () -> Unit) {
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
                top = 30.dp, bottom = 20.dp, start = 12.dp, end = 12.dp
            )
        ) {
            var emailText by remember { mutableStateOf("") }
            var password by rememberSaveable { mutableStateOf("") }
            var passwordHidden by rememberSaveable { mutableStateOf(true) }

            MyOutlinedTextField(
                value = emailText, onValueChange = { emailText = it }, label = "Email"
            )

            Spacer(modifier = Modifier.height(18.dp))

            OutlinedTextField(modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.white)),
                value = password,
                onValueChange = { password = it },
                label = { androidx.compose.material.Text("Enter password") },
                visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = { passwordHidden = !passwordHidden }) {
                        val visibilityIcon =
                            if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                        val description = if (passwordHidden) "Show password" else "Hide password"
                        Icon(imageVector = visibilityIcon, contentDescription = description)
                    }
                })


            Spacer(modifier = Modifier.height(20.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.ForgotPassword),
                fontFamily = FontFamily(Font(R.font.semibold)),
                color = colorResource(id = R.color.black),
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { navigateToHome.invoke() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White,
                ),
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
                    .shadow(4.dp, shape = MaterialTheme.shapes.medium, clip = false)

            ) {
                Text(
                    text = "Login",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.regular)),
                    modifier = Modifier.padding(6.dp)
                ).toString()
            }


            Spacer(modifier = Modifier.height(6.dp))

            Button(
                onClick = { navigateToSignUp.invoke()},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black,
                ),
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
                    .shadow(4.dp, shape = MaterialTheme.shapes.medium, clip = false)
            ) {
                Text(
                    text = stringResource(id = R.string.sign_up),
                    fontSize = 14.sp,
                )

            }
        }
    }
}

