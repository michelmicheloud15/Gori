package com.mustadevs.gori.data.repository


import android.os.Build
import androidx.annotation.RequiresExtension
import com.mustadevs.gori.data.repository.dataSource.AuthLocalDataSource
import com.mustadevs.gori.data.repository.dataSource.AuthRemoteDataSource
import com.mustadevs.gori.domain.model.AuthResponse
import com.mustadevs.gori.domain.model.User
import com.mustadevs.gori.domain.repository.AuthRepository
import com.mustadevs.gori.domain.util.Resource
import com.mustadevs.gori.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
    ): AuthRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun login(email: String, password: String): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.login(email, password)
    )


    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun register(user: User): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.register(user)
    )

    override suspend fun saveSession(authResponse: AuthResponse) = authLocalDataSource.saveSession(authResponse)
    override suspend fun logout() = authLocalDataSource.logout()
    override fun getSessionData(): Flow<AuthResponse> = authLocalDataSource.getSessionData()


}