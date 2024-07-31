package com.mustadevs.gori.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.mustadevs.gori.presentation.ui.theme.DarkPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (value: String) -> Unit,
    label: String,
    icon: ImageVector,
    keyboardType: KeyboardType = KeyboardType.Text,
    hideText: Boolean = false
){
    OutlinedTextField(

        modifier = modifier,
        value = value,
        onValueChange = {
                        text -> onValueChange(text)
        },
        label = {
            Text(text= label)
        },
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = "",
                tint = DarkPrimary
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType=keyboardType),
        visualTransformation = if (hideText) PasswordVisualTransformation() else VisualTransformation.None
        )
}