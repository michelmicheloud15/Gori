package com.mustadevs.gori.presentation.screens.auth.register

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.mustadevs.gori.presentation.components.DefaultTopBar
import com.mustadevs.gori.presentation.screens.auth.register.components.Register
import com.mustadevs.gori.presentation.screens.auth.register.components.RegisterContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavHostController){

    Scaffold(
        topBar={
            DefaultTopBar(
                title = "Registro",
                upAvailable = true,
                navController = navController
                )
        },


    ) { paddingValues ->
        RegisterContent(paddingValues = paddingValues)
    }
    Register(navController)
}