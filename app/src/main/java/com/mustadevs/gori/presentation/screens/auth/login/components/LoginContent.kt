package com.mustadevs.gori.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mustadevs.gori.R
import com.mustadevs.gori.presentation.components.DefaultButton
import com.mustadevs.gori.presentation.components.DefaultTextField
import com.mustadevs.gori.presentation.navigation.screen.auth.AuthScreen
import com.mustadevs.gori.presentation.screens.auth.login.LoginViewModel
import com.mustadevs.gori.presentation.ui.theme.DarkPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginContent(navController: NavHostController, paddingValues: PaddingValues, vm: LoginViewModel = hiltViewModel()){

    val state = vm.state
    val context = LocalContext.current

    LaunchedEffect(key1 = vm.errorMessage){
        if(vm.errorMessage != ""){
            Toast.makeText(context, vm.errorMessage, Toast.LENGTH_LONG).show()
            vm.errorMessage = ""
        }
    }
    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .fillMaxSize()){
        Image(
            modifier = Modifier
                //.fillMaxSize()
                .padding(top = 1.dp),
            painter = painterResource(id = R.drawable.ic_logo_boca_abierta),
            contentDescription = "Imagen de fondo",
            //contentScale = ContentScale.Crop,
            //colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
            //    setToScale(redScale = 0.5f, greenScale = 0.5f, blueScale = 0.5f, alphaScale = 1f)
            //})
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            //Image(
            //    modifier = Modifier
            //        .height(100.dp)
            //        .width(100.dp),
            //    painter = painterResource(id = R.drawable.ic_logo_png_exportado),
            //    contentDescription = "Logo"
            //)
            //Text(
              // modifier = Modifier.padding(bottom=50.dp),
              // text = "GORI",
              // fontWeight = FontWeight.Bold,
              //  color = Color.Black,
             //   fontSize = 40.sp
           // )
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(330.dp),
                shape = RoundedCornerShape(
                    topEnd = 30.dp,
                    topStart = 30.dp
                ),
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.7f))
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 30.dp, end = 30.dp, start = 30.dp)
                        .verticalScroll(rememberScrollState())
                ){
                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = "INGRESAR",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color= Color.Black
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.email,
                        onValueChange = {text ->
                            vm.onEmailInput(text)
                                        },
                        label = "Correo electrónico",
                        icon = Icons.Default.Email,
                        keyboardType = KeyboardType.Email
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.password,
                        onValueChange = {text ->
                            vm.onPasswordInput(text)
                        },
                        label = "Contraseña",
                        icon = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password,
                        hideText = true
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),

                        text = "LOGIN",
                        onClick = {vm.login() },
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 17.dp),
                        horizontalArrangement = Arrangement.Center,
                    ){
                        Text(text="¿Aun no tenés una cuenta? ")
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            modifier = Modifier.clickable { navController.navigate(route= AuthScreen.Register.route) },
                            text="Registrate",
                            color= DarkPrimary
                        )
                    }
                }

            }
        }
    }
}