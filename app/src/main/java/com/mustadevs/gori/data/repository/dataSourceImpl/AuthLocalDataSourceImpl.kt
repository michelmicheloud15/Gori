package com.mustadevs.gori.data.repository.dataSourceImpl

import com.mustadevs.gori.data.datastore.AuthDatastore
import com.mustadevs.gori.data.repository.dataSource.AuthLocalDataSource
import com.mustadevs.gori.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor (private val authDatastore: AuthDatastore):
    AuthLocalDataSource {
    override suspend fun saveSession(authResponse: AuthResponse) = authDatastore.save(authResponse)
    override suspend fun logout() = authDatastore.delete()

    override fun getSessionData(): Flow<AuthResponse> = authDatastore.getData()
}