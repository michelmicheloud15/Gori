package com.mustadevs.gori.presentation.screens.admin.category.list.components

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mustadevs.gori.domain.util.Resource
import com.mustadevs.gori.presentation.components.ProgressBar
import com.mustadevs.gori.presentation.screens.admin.category.list.AdminCategoryListViewModel

@Composable
fun GetCategories(navController: NavHostController, paddingValues: PaddingValues, vm: AdminCategoryListViewModel = hiltViewModel()){

    when(val response = vm.categoriesResponse) {
        Resource.Loading -> {
            ProgressBar()
        }

        is Resource.Success -> { //is por ser data class
            AdminCategoryListContent(navController, categories = response.data, paddingValues )
        }

        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }

        else -> {
            if (response != null) {
                Toast.makeText(
                    LocalContext.current,
                    "Hubo un error desconocido.",
                    Toast.LENGTH_LONG
                ).show()
            }

        }
    }
}