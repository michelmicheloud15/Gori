package com.mustadevs.gori.presentation.navigation.graph.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.mustadevs.gori.presentation.navigation.Graph
import com.mustadevs.gori.presentation.navigation.screen.profile.ProfileScreen
import com.mustadevs.gori.presentation.screens.profile.update.ProfileUpdateScreen

fun NavGraphBuilder.ProfileNavGraph(navController: NavHostController){
    navigation(
        route = Graph.PROFILE + "/{user}",
        startDestination = ProfileScreen.ProfileUpdate.route
    ) {
        composable(
            route = ProfileScreen.ProfileUpdate.route,
            arguments = listOf(navArgument("user"){
                type = NavType.StringType
            })
            ) {
            it.arguments?.getString("user")?.let{
            ProfileUpdateScreen(navController, userParam = it)}
    }
    }
}