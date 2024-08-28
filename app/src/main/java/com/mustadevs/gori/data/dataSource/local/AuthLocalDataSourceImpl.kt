package com.mustadevs.gori.data.dataSource.local

import com.mustadevs.gori.data.dataSource.local.datastore.AuthDatastore
import com.mustadevs.gori.data.dataSource.local.AuthLocalDataSource
import com.mustadevs.gori.domain.model.AuthResponse
import com.mustadevs.gori.domain.model.User
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor (private val authDatastore: AuthDatastore):
    AuthLocalDataSource {
    override suspend fun saveSession(authResponse: AuthResponse) = authDatastore.save(authResponse)
    override suspend fun updateSession(user: User) = authDatastore.update(user)
    override suspend fun logout() = authDatastore.delete()

    override fun getSessionData(): Flow<AuthResponse> = authDatastore.getData()
}