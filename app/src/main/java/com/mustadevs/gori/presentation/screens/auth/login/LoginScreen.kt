@file:OptIn(ExperimentalMaterial3Api::class)

package com.mustadevs.gori.presentation.screens.auth.login

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.mustadevs.gori.presentation.screens.auth.login.components.Login
import com.mustadevs.gori.presentation.screens.auth.login.components.LoginContent


@Composable
fun LoginScreen(navController: NavHostController){
    Scaffold(
    ){ paddingValues ->
        LoginContent(navController = navController, paddingValues)
    }
    Login(navController = navController)
}
