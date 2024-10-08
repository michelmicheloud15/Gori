package com.mustadevs.gori.presentation.navigation.graph.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.mustadevs.gori.presentation.navigation.Graph
import com.mustadevs.gori.presentation.navigation.screen.admin.AdminCategoryScreen
import com.mustadevs.gori.presentation.screens.admin.category.create.AdminCategoryCreateScreen
import com.mustadevs.gori.presentation.screens.admin.category.update.AdminCategoryUpdateScreen
import com.mustadevs.gori.presentation.screens.admin.product.create.AdminProductCreateScreen
import com.mustadevs.gori.presentation.screens.admin.product.list.AdminProductListScreen
import com.mustadevs.gori.presentation.screens.admin.product.update.AdminProductUpdateScreen

fun NavGraphBuilder.AdminCategoryNavGraph(navController: NavHostController){
    navigation(
        route = Graph.ADMIN_CATEGORY,
        startDestination = AdminCategoryScreen.CategoryCreate.route
    ){
            composable(route= AdminCategoryScreen.CategoryCreate.route){
            AdminCategoryCreateScreen(navController)
        }

        composable(route= AdminCategoryScreen.CategoryUpdate.route,
            arguments = listOf(navArgument("category"){
                type = NavType.StringType
            })){
            it.arguments?.getString("category")?.let{
                AdminCategoryUpdateScreen(navController, it)
            }
        }

        composable(route= AdminCategoryScreen.ProductList.route,
            arguments = listOf(navArgument("category"){
                type = NavType.StringType
            })){
            it.arguments?.getString("category")?.let{
                AdminProductListScreen(navController, it)
            }
        }
        composable(route= AdminCategoryScreen.ProductCreate.route,
            arguments = listOf(navArgument("category"){
                type = NavType.StringType
            })){
            it.arguments?.getString("category")?.let{
                AdminProductCreateScreen(navController, it)
            }
        }

        composable(route= AdminCategoryScreen.ProductUpdate.route,
            arguments = listOf(navArgument("product"){
                type = NavType.StringType
            })){
            it.arguments?.getString("product")?.let{
                AdminProductUpdateScreen(navController, it)
            }
        }


    }
}