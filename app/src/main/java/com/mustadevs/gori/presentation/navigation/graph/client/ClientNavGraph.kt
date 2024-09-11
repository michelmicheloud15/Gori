package com.mustadevs.gori.presentation.navigation.graph.client

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mustadevs.gori.presentation.navigation.Graph
import com.mustadevs.gori.presentation.navigation.graph.profile.ProfileNavGraph
import com.mustadevs.gori.presentation.navigation.screen.client.ClientScreen
import com.mustadevs.gori.presentation.screens.client.category.list.ClientCategoryListScreen
import com.mustadevs.gori.presentation.screens.client.product.list.ClientProductListScreen
import com.mustadevs.gori.presentation.screens.profile.info.ProfileScreen

@Composable
fun ClientNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.ProductList.route //pantalla principal de producto
    ){
        composable(route = ClientScreen.ProductList.route){
            ClientProductListScreen(navController)
        }
        composable(route = ClientScreen.CategoryList.route){
            ClientCategoryListScreen(navController)
        }
        composable(route = ClientScreen.Profile.route){
            ProfileScreen(navController)
        }
        ProfileNavGraph(navController)
        ClientCategoryNavGraph(navController)
    }
}