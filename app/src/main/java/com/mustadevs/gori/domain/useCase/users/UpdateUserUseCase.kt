package com.mustadevs.gori.domain.useCase.users

import com.mustadevs.gori.domain.model.User
import com.mustadevs.gori.domain.repository.UsersRepository

class UpdateUserUseCase constructor(private val repository: UsersRepository) {
    suspend operator fun invoke(id: String, user: User) = repository.update(id, user)
}