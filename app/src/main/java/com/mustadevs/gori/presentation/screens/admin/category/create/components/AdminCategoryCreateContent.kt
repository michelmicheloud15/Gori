package com.mustadevs.gori.presentation.screens.admin.category.create.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.mustadevs.gori.R
import com.mustadevs.gori.presentation.components.DefaultButton
import com.mustadevs.gori.presentation.components.DefaultTextField
import com.mustadevs.gori.presentation.components.DialogCapturePicture
import com.mustadevs.gori.presentation.screens.admin.category.create.AdminCategoryCreateViewModel

@Composable
fun AdminCategoryCreateContent(paddingValues: PaddingValues, vm: AdminCategoryCreateViewModel = hiltViewModel()) {
    val state = vm.state
    vm.resultingActivityHandler.handle()
    val stateDialog = remember { mutableStateOf(false) }

    DialogCapturePicture(
        state = stateDialog,
        takePhoto = {vm.takePhoto() },
        pickImage = { vm.pickImage() }
    )
    Column(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        //Si el usuario cargo imagen:
        if(!state.image.isNullOrBlank()){
            AsyncImage(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 15.dp)
                    .clickable { stateDialog.value = true },
                model = state.image,
                contentDescription = "",

            )
        }
        else { //Usuario no cargo imagen, va la imagen de icono generico
            Image(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 15.dp)
                    .clickable { stateDialog.value = true },
                painter = painterResource(id = R.drawable.image_add), contentDescription = ""
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shape = RoundedCornerShape(
                topEnd = 40.dp,
                topStart = 40.dp
            ),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ){
            Column(
                modifier = Modifier.padding(20.dp)
            ){
                Text(
                    modifier = Modifier.padding(bottom = 20.dp),
                    text = "CATEGORÍA",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.name,
                    onValueChange = { vm.onNameInput(it)},
                    label = "Nombre de la categoría",
                    icon = Icons.Default.List
                )
                DefaultTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    value = state.description,
                    onValueChange = { vm.onDescriptionInput(it) },
                    label = "Descripción",
                    icon = Icons.Outlined.Info
                )
                Spacer(modifier = Modifier.height(40.dp))
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Crear Categoría",
                    onClick = { vm.createCategory() }
                )
            }
        }
    }
}