package com.mustadevs.gori.presentation.screens.client.product.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.mustadevs.gori.domain.model.Product
import com.mustadevs.gori.presentation.screens.client.product.list.ClientProductListItem

@Composable
fun ClientProductListContent(navController: NavHostController, paddingValues: PaddingValues, products: List<Product>){
    LazyColumn(
        modifier = Modifier
            .padding()
    ){
        items(items = products){product->
            ClientProductListItem(navController, product)

        }
    }
}