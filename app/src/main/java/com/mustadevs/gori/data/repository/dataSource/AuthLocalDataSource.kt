package com.mustadevs.gori.data.repository.dataSource

import com.mustadevs.gori.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow

interface AuthLocalDataSource {

    suspend fun saveSession(authResponse: AuthResponse)
    suspend fun logout()
    fun getSessionData(): Flow<AuthResponse>

}