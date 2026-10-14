package com.sahil.a24012011037_mad_practical_5

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun AppNavigation(
    context: Context = LocalContext.current
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(
                context = context,
                navController = navController
            )
        }

        composable("register") {
            RegisterScreen(
                context = context,
                navController = navController
            )
        }
    }
}