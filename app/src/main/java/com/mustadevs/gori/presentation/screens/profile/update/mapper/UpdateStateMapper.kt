package com.mustadevs.gori.presentation.screens.profile.update.mapper

import com.mustadevs.gori.domain.model.User
import com.mustadevs.gori.presentation.screens.profile.update.ProfileUpdateState

fun ProfileUpdateState.toUser(): User {
    return User(
        name = name,
        lastname = lastname,
        phone = phone,
        image = image
    )
}