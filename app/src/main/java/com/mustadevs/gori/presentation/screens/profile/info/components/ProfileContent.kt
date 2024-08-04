package com.mustadevs.gori.presentation.screens.profile.info.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.mustadevs.gori.R
import com.mustadevs.gori.presentation.MainActivity
import com.mustadevs.gori.presentation.components.DefaultButton
import com.mustadevs.gori.presentation.navigation.Graph
import com.mustadevs.gori.presentation.screens.profile.info.ProfileViewModel

@Composable
fun ProfileContent(paddingValues: PaddingValues, navController: NavHostController,vm: ProfileViewModel = hiltViewModel())
{ //sacar el vm para obtener preview
   val activity = LocalContext.current as? Activity

    Box(modifier = Modifier.padding(paddingValues = paddingValues).padding(bottom = 55.dp)){
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.ic_reme_jero),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply{
                    setToScale(0.6f, 0.6f, 0.6f, 1f)
                }
            )
        )

        Column(modifier = Modifier.fillMaxWidth()){
            IconButton(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 15.dp, top = 15.dp),
                onClick = {
                    vm.logout()
                    activity?.finish()
                    activity?.startActivity(Intent(activity, MainActivity::class.java))
                }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                    contentDescription = ""
                )
            }
            //Si el usuario cargo imagen:
            if(!vm.user?.image.isNullOrBlank()){
                AsyncImage(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally),
                    model = vm.user?.image,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
            else { //Usuario no cargo imagen, va la imagen de icono generico
                Image(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally),
                    painter = painterResource(id = R.drawable.user_image), contentDescription = ""
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp
                ),
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.7f))
            ){
                Column(
                    modifier = Modifier.padding(20.dp)
                    ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(imageVector = Icons.Default.Person,
                            contentDescription = ""
                        )
                        Column(modifier = Modifier.padding(horizontal = 5.dp)){
                            Text(text = "${vm.user?.name} ${vm.user?.lastname}")
                            Text(
                                text = "Nombre de usuario",
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(imageVector = Icons.Default.Email,
                            contentDescription = ""
                        )
                        Column(modifier = Modifier.padding(horizontal = 5.dp)){
                            Text(text = vm.user?.email ?: "")
                            Text(
                                text = "Correo electrónico",
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(imageVector = Icons.Default.Phone,
                            contentDescription = ""
                        )
                        Column(modifier = Modifier.padding(horizontal = 5.dp)){
                            Text(text = vm.user?.phone ?: "")
                            Text(
                                text = "Teléfono",
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(40.dp))
                    DefaultButton(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Actualizar información",
                        onClick = {
                            navController.navigate(route = "${Graph.PROFILE}/${vm.user?.toJson()}")
                                }
                            )
                    }
                }
            }
        }
}
