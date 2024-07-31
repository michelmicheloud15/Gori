package com.mustadevs.gori.domain.useCase.auth

import com.mustadevs.gori.domain.repository.AuthRepository

class GetSessionDataUseCase constructor(private val repository: AuthRepository) {

    operator fun invoke() = repository.getSessionData()
}