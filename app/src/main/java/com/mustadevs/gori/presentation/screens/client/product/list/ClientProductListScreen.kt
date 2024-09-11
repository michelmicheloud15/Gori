package com.mustadevs.gori.presentation.screens.client.product.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.mustadevs.gori.presentation.screens.client.product.list.components.GetProducts

@Composable
fun ClientProductListScreen(navController: NavHostController){
    Scaffold() { paddingValues ->
        GetProducts(navController = navController, paddingValues = paddingValues)
    }
}