package com.mustadevs.gori.presentation.screens.profile.update

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.mustadevs.gori.presentation.components.DefaultTopBar
import com.mustadevs.gori.presentation.screens.profile.update.components.ProfileUpdateContent

@Composable
fun ProfileUpdateScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Actualizar perfil",
                navController = navController,
                upAvailable = true
            )
        }
    ) {
        ProfileUpdateContent(paddingValues = it)
    }
}