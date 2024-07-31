package com.mustadevs.gori.presentation.screens.client.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mustadevs.gori.presentation.navigation.graph.client.ClientNavGraph
import com.mustadevs.gori.presentation.screens.client.home.components.ClientBottomBar


@Composable
fun ClientHomeScreen(navController: NavHostController = rememberNavController()){
    Scaffold(
        bottomBar = { ClientBottomBar(navController = navController)}
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues))
        ClientNavGraph(navController = navController)
    }
}