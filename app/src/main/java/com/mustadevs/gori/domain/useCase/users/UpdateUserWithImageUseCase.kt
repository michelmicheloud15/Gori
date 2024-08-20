package com.mustadevs.gori.domain.useCase.users

import com.mustadevs.gori.domain.model.User
import com.mustadevs.gori.domain.repository.UsersRepository
import java.io.File

class UpdateUserWithImageUseCase constructor(private val repository: UsersRepository) {
    suspend operator fun invoke(id: String, user: User, file: File) = repository.updateWithImage(id, user, file)
}