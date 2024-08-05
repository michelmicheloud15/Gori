package com.mustadevs.gori.di

import com.mustadevs.gori.data.repository.AuthRepositoryImpl
import com.mustadevs.gori.data.repository.UsersRepositoryImpl
import com.mustadevs.gori.data.repository.dataSource.AuthLocalDataSource
import com.mustadevs.gori.data.repository.dataSource.AuthRemoteDataSource
import com.mustadevs.gori.data.repository.dataSource.UsersRemoteDataSource
import com.mustadevs.gori.domain.repository.AuthRepository
import com.mustadevs.gori.domain.repository.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(
        authRemoteDataSource: AuthRemoteDataSource,
                              authLocalDataSource: AuthLocalDataSource
                              ): AuthRepository = AuthRepositoryImpl(authRemoteDataSource, authLocalDataSource)

    @Provides
    fun provideUsersRepository(
        usersRemoteDataSource: UsersRemoteDataSource,
    ): UsersRepository = UsersRepositoryImpl(usersRemoteDataSource)
}