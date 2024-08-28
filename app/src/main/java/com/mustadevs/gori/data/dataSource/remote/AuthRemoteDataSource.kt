package com.mustadevs.gori.data.dataSource.remote

import com.mustadevs.gori.domain.model.AuthResponse
import com.mustadevs.gori.domain.model.User
import retrofit2.Response

interface AuthRemoteDataSource {

    suspend fun login(email: String, password: String): Response<AuthResponse>
    suspend fun register(user: User): Response<AuthResponse>

}