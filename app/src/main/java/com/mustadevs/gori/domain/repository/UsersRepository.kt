package com.mustadevs.gori.domain.repository

import com.mustadevs.gori.domain.model.User
import com.mustadevs.gori.domain.util.Resource
import java.io.File

interface UsersRepository {
    suspend fun update(id: String, user: User): Resource<User>

    suspend fun updateWithImage(id: String, user: User, file: File): Resource<User>
}