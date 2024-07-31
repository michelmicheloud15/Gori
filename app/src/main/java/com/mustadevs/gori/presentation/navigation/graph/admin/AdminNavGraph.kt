package com.mustadevs.gori.presentation.navigation.graph.admin

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mustadevs.gori.presentation.navigation.Graph
import com.mustadevs.gori.presentation.navigation.graph.profile.ProfileNavGraph
import com.mustadevs.gori.presentation.navigation.screen.admin.AdminScreen
import com.mustadevs.gori.presentation.screens.admin.category.list.AdminCategoryListScreen
import com.mustadevs.gori.presentation.screens.admin.product.list.AdminProductListScreen
import com.mustadevs.gori.presentation.screens.profile.info.ProfileScreen

@Composable
fun AdminNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        route = Graph.ADMIN,
        startDestination = AdminScreen.ProductList.route //pantalla principal de producto
    ){
        composable(route = AdminScreen.ProductList.route){
            AdminProductListScreen()
        }
        composable(route = AdminScreen.CategoryList.route){
            AdminCategoryListScreen()
        }
        composable(route = AdminScreen.Profile.route){
            ProfileScreen(navController)
        }
        ProfileNavGraph(navController)

    }
}