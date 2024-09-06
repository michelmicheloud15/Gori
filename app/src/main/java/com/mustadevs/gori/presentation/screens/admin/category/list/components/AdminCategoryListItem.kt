package com.mustadevs.gori.presentation.screens.admin.category.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.mustadevs.gori.R
import com.mustadevs.gori.domain.model.Category
import com.mustadevs.gori.presentation.navigation.screen.admin.AdminCategoryScreen
import com.mustadevs.gori.presentation.screens.admin.category.list.AdminCategoryListViewModel

@Composable
fun AdminCategoryListItem(navController: NavHostController, category: Category, vm: AdminCategoryListViewModel = hiltViewModel()) {
    Column(
        Modifier
            .padding(start = 20.dp, end = 20.dp, top = 15.dp)
            .height(90.dp)
            .clickable { navController.navigate(route=AdminCategoryScreen.ProductList.passCategory(category.toJson())) }
    ) {
        Row(){
            AsyncImage(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(10.dp)),
                model = category.image,
                contentDescription = ""
            )
            Spacer(modifier=Modifier.width(10.dp))
            Column(
                Modifier.weight(1f)
            ){
                Text(text = category.name,
                    color = Color.Black,
                    fontSize = 17.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = category.name,
                    color = Color.Gray,
                    fontSize = 17.sp
                )
            }
            Spacer(modifier = Modifier.width(15.dp))
            Column(
                verticalArrangement =  Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(27.dp)
                        .clickable {
                            navController.navigate(
                                route = AdminCategoryScreen.CategoryUpdate.passCategory(
                                    category.toJson()
                                )
                            )
                        },
                    painter = painterResource(id = R.drawable.edit),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.height(5.dp))
                Image(
                    modifier = Modifier
                        .size(27.dp)
                        .clickable { vm.deleteCategory(category.id!!) },
                    painter = painterResource(id = R.drawable.trash),
                    contentDescription = ""
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            color = Color.LightGray,
            startIndent = 30.dp
        )
    }


}