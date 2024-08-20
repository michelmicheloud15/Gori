package com.mustadevs.gori.presentation.screens.admin.category.update

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.mustadevs.gori.presentation.components.DefaultTopBar
import com.mustadevs.gori.presentation.screens.admin.category.update.components.AdminCategoryUpdateContent
import com.mustadevs.gori.presentation.screens.admin.category.update.components.UpdateCategory

@Composable
fun AdminCategoryUpdateScreen(navController: NavHostController, categoryParam: String) {

    Log.d("AdminCategoryUpdateScreen", "Data: $categoryParam")

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Actualizar Categoría",
                upAvailable = true,
                navController = navController
                )
        }
    ) {paddingValues ->
        AdminCategoryUpdateContent(paddingValues = paddingValues)

    }
    UpdateCategory()
}