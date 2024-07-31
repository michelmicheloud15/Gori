package com.mustadevs.gori.presentation.screens.roles

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.mustadevs.gori.presentation.components.DefaultTopBar
import com.mustadevs.gori.presentation.screens.roles.components.RolesContent

@Composable
fun RolesScreen(navController: NavHostController){

    Scaffold(
        topBar = {DefaultTopBar(title = "Seleccionar un rol")}
    ) { paddingValues ->
        RolesContent(paddingValues, navController)
    }
}