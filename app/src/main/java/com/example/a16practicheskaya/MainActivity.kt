package com.example.a16practicheskaya

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.a16practicheskaya.screen.LoginScreen
import com.example.a16practicheskaya.screen.MainScreen
import com.example.a16practicheskaya.screen.OnboardingScreen
import com.example.a16practicheskaya.screen.ProfileScreen
import com.example.a16practicheskaya.screen.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("onboarding") { OnboardingScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("main") { MainScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
        composable("photo") { PhotoScreen() }
    }
}
