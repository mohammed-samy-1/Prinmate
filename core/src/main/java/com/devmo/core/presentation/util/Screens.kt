package com.devmo.core.presentation.util

sealed class Screens(val route: String) {
    object Splash : Screens("SPLASH")
    object Splash2 : Screens("SPLASH_2")
    object Login : Screens("LOGIN")
    object SignUp : Screens("SIGN_UP")
}
