package com.mustadevs.gori.presentation.screens.admin.category.create

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.mustadevs.gori.presentation.components.DefaultTopBar
import com.mustadevs.gori.presentation.screens.admin.category.create.components.AdminCategoryCreateContent
import com.mustadevs.gori.presentation.screens.admin.category.create.components.CreateCategory

@Composable
fun AdminCategoryCreateScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nueva Categoría",
                upAvailable = true,
                navController = navController
                )
        }
    ) {paddingValues ->
        AdminCategoryCreateContent(paddingValues = paddingValues)

    }
    CreateCategory()
}