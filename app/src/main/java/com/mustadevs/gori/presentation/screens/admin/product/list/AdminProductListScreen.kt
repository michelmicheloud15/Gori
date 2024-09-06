package com.mustadevs.gori.presentation.screens.admin.product.list

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mustadevs.gori.domain.model.Category
import com.mustadevs.gori.presentation.navigation.screen.admin.AdminCategoryScreen
import com.mustadevs.gori.presentation.screens.admin.product.list.components.GetProducts

@Composable
fun AdminProductListScreen(navController: NavHostController, categoryParam: String){
    Log.d("AdminProductListScreen", "Category: ${categoryParam}")
    val categoryParse = Category.fromJson(categoryParam).toJson()
    Scaffold(
        floatingActionButton = {
        FloatingActionButton(
            modifier = Modifier.padding(bottom = 20.dp),
            onClick = { navController.navigate(route = AdminCategoryScreen.ProductCreate.passCategory(categoryParse)) },
            containerColor = Color.Red
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription="",
                tint = Color.DarkGray
            )

        }
    }) {paddingValues ->
        GetProducts(navController = navController, paddingValues = paddingValues)
    }
}