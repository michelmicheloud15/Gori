package com.mustadevs.gori.data.repository.dataSource

import com.mustadevs.gori.domain.model.AuthResponse
import com.mustadevs.gori.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthLocalDataSource {

    suspend fun saveSession(authResponse: AuthResponse)
    suspend fun updateSession(user: User)
    suspend fun logout()
    fun getSessionData(): Flow<AuthResponse>

}