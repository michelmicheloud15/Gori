package com.mustadevs.gori.presentation.screens.auth.register.mapper

import com.mustadevs.gori.domain.model.User
import com.mustadevs.gori.presentation.screens.auth.register.RegisterState

fun RegisterState.toUser(): User {
    return User(
        name = name,
        lastname = lastname,
        email = email,
        phone = phone,
        password = password

    )
}