package com.devmo.prinmate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.devmo.auth.presentation.login.components.LoginScreen
import com.devmo.auth.presentation.signup.components.SignUpScreen
import com.devmo.auth.presentation.splash.components.SplashScreen
import com.devmo.auth.presentation.splash.components.SplashScreen2
import com.devmo.core.presentation.util.Screens

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screens.Splash.route) {
        composable(route = Screens.Splash.route){
            SplashScreen(navController = navController)
        }
        composable(route = Screens.Splash2.route){
            SplashScreen2(navController = navController)
        }
        composable(route = Screens.Login.route){
            LoginScreen(navController = navController)
        }
        composable(route = Screens.SignUp.route){
            SignUpScreen(navController = navController)
        }
    }
}