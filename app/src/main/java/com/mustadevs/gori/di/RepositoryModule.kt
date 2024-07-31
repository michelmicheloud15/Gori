package com.mustadevs.gori.di

import com.mustadevs.gori.data.repository.AuthRepositoryImpl
import com.mustadevs.gori.data.repository.dataSource.AuthLocalDataSource
import com.mustadevs.gori.data.repository.dataSource.AuthRemoteDataSource
import com.mustadevs.gori.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(authRemoteDataSource: AuthRemoteDataSource,
                              authLocalDataSource: AuthLocalDataSource
                              ): AuthRepository = AuthRepositoryImpl(authRemoteDataSource, authLocalDataSource)
}