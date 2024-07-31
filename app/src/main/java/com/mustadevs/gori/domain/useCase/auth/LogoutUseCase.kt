package com.mustadevs.gori.domain.useCase.auth

import com.mustadevs.gori.domain.repository.AuthRepository

class LogoutUseCase constructor(private val repository: AuthRepository) {

    suspend operator fun invoke() = repository.logout()
}