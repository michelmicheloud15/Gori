package com.mustadevs.gori.data.repository.dataSourceImpl

import com.mustadevs.gori.data.repository.dataSource.AuthRemoteDataSource
import com.mustadevs.gori.data.service.AuthService
import com.mustadevs.gori.domain.model.AuthResponse
import com.mustadevs.gori.domain.model.User
import retrofit2.Response

class AuthRemoteDataSourceImpl(private val authService: AuthService): AuthRemoteDataSource {

    override suspend fun login(email: String, password: String) = authService.login(email, password)
    override suspend fun register(user: User): Response<AuthResponse> = authService.register(user)
}