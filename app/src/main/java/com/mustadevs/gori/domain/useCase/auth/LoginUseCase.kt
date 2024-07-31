package com.mustadevs.gori.domain.useCase.auth

import com.mustadevs.gori.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)
}