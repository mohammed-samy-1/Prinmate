package com.devmo.core.presentation.util

sealed class Screens(val route: String) {
    object Splash : Screens("SPLASH")
    object Login : Screens("LOGIN")
    object SignUp : Screens("SIGN_UP")
}
