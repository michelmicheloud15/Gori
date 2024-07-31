package com.mustadevs.gori.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mustadevs.gori.domain.util.Resource
import com.mustadevs.gori.presentation.components.ProgressBar
import com.mustadevs.gori.presentation.navigation.Graph
import com.mustadevs.gori.presentation.screens.auth.login.LoginViewModel


@Composable
fun Login(navController: NavHostController, vm: LoginViewModel = hiltViewModel()){

    when(val response = vm.loginResponse){
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {

            //is por ser data class
            LaunchedEffect(Unit){
                vm.saveSession(response.data)
                if(response.data.user?.roles!!.size > 1) {
                    //MAS DE UN ROL
                    navController.navigate(route = Graph.ROLES){
                        popUpTo(Graph.AUTH){
                            inclusive = true
                        }
                    }
                }
                else{ // UN SOLO ROL
                    navController.navigate(route = Graph.CLIENT){
                        popUpTo(Graph.AUTH){
                            inclusive = true
                        }
                    }
                }

            }
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT).show()
        }

        else -> {
            if(response != null){
                Toast.makeText(LocalContext.current, "Hubo un error desconocido.", Toast.LENGTH_SHORT).show()
            }

        }
    }
}