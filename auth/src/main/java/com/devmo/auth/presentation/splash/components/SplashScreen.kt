package com.devmo.auth.presentation.splash.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.devmo.auth.R
import com.devmo.core.presentation.util.Screens
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(navController: NavController) {
    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = true)
    {
        scope.launch {
            delay(500)
            navController.navigate(Screens.Splash2.route){
                popUpTo(Screens.Splash.route){ inclusive = true }
            }
        }
    }
    Column(
        Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background))
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(
                    R.string.logo
                )
            )
        }
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.printing_invoices_amico_1),
                contentDescription = stringResource(
                    R.string.logo
                )
            )
        }
    }
}

@Composable
fun SplashScreen2(navController: NavController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background))
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(
                    R.string.logo
                )
            )
        }
        Spacer(modifier = Modifier.height(36.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { navController.navigate(Screens.Login.route) },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text(
                text = stringResource(R.string.login),
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.W500,
                ),
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = { navController.navigate(Screens.SignUp.route) },
            border = BorderStroke(
                1.dp,
                MaterialTheme.colorScheme.primary
            ),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text(
                text = stringResource(R.string.signup),
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.W500,
                ),
                color = Color.White,

                )
        }
    }
}

