package com.mustadevs.gori.domain.repository

import com.mustadevs.gori.domain.model.AuthResponse
import com.mustadevs.gori.domain.model.User
import com.mustadevs.gori.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    suspend fun login(email: String, password: String): Resource<AuthResponse>
    suspend fun register(user: User): Resource<AuthResponse>
    suspend fun saveSession(authResponse: AuthResponse)
    suspend fun updateSession(user: User)
    suspend fun logout()
    fun getSessionData(): Flow<AuthResponse>
}