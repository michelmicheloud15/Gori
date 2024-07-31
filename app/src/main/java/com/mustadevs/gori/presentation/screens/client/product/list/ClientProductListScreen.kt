package com.mustadevs.gori.presentation.screens.client.product.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.mustadevs.gori.presentation.screens.client.product.list.components.ClientProductListContent

@Composable
fun ClientProductListScreen(){
    Scaffold() {
        ClientProductListContent(paddingValues = it)
    }
}