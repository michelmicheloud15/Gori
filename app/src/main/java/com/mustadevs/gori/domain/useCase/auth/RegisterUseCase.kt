package com.mustadevs.gori.domain.useCase.auth

import com.mustadevs.gori.domain.model.User
import com.mustadevs.gori.domain.repository.AuthRepository

class RegisterUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(user: User)= repository.register(user)
}