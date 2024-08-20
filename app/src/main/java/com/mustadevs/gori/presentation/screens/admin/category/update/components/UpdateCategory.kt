package com.mustadevs.gori.presentation.screens.admin.category.update.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.mustadevs.gori.domain.util.Resource
import com.mustadevs.gori.presentation.components.ProgressBar
import com.mustadevs.gori.presentation.screens.admin.category.update.AdminCategoryUpdateViewModel


@Composable
fun UpdateCategory(vm: AdminCategoryUpdateViewModel = hiltViewModel()){

    when(val response = vm.categoryResponse){
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> { //is por ser data class
            Toast.makeText(LocalContext.current, "Los datos se han actualizado correctamente", Toast.LENGTH_LONG).show()
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }

        else -> {
            if(response != null){
                Toast.makeText(LocalContext.current, "Hubo un error desconocido.", Toast.LENGTH_LONG).show()
            }

        }
    }
}