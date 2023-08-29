package com.devmo.auth.presentation.login.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.devmo.auth.R
import com.devmo.auth.presentation.common.components.AuthTextFiled
import com.devmo.core.presentation.util.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController
) {
    // TODO: link viewModel
    val config = LocalConfiguration.current
    val padding = (config.smallestScreenWidthDp * 0.05).dp
    val height = config.screenHeightDp
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background))
            .padding(horizontal = padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Box(
            modifier = Modifier,
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = R.string.login),
                style = MaterialTheme.typography.displayLarge
                    .copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height((height * 0.125).dp))
        AuthTextFiled(
            text = "",
            hint = stringResource(R.string.email),
            onValueChange = {},
            onFocusChange = {})

        Spacer(modifier = Modifier.height(16.dp))

        AuthTextFiled(
            text = "",
            hint = stringResource(R.string.password),
            onValueChange = {},
            onFocusChange = {},
            isPassword = true
        )

        Spacer(modifier = Modifier.height((height * 0.1).dp))

        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = { /*TODO*/ },
            border = BorderStroke(
                1.dp,
                MaterialTheme.colorScheme.primary
            ),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text(
                text = stringResource(R.string.login),
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.W500,
                ),
                color = Color.White,

                )
        }

        Spacer(modifier = Modifier.height(16.dp))
        val annotatedString = buildAnnotatedString {
            append(stringResource(R.string.don_t_have_an_account))
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.primary,
                ),
            ) {
                append(stringResource(id = R.string.signup))
            }
        }

        Text(
            annotatedString,
            modifier = Modifier.clickable {
                navController.navigate(Screens.SignUp.route) {
                    popUpTo(Screens.Splash2.route)
                }
            }
        )


    }
}