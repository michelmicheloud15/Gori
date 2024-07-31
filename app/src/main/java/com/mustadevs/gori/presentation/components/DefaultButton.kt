package com.mustadevs.gori.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.mustadevs.gori.presentation.ui.theme.DarkPrimary

@Composable
fun DefaultButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit,
    color: Color = DarkPrimary,
    //icon: ImageVector = Icons.Default.ArrowForward
    ){
    Button(
        modifier = modifier,
        onClick = { onClick()},
        colors = ButtonDefaults.buttonColors(containerColor = color) //ver
    ) {
        //Icon(
        //    imageVector = icon,
        //    contentDescription = ""
       // )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text= text)
    }
}