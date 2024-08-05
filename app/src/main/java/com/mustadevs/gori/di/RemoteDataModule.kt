package com.mustadevs.gori.di

import com.mustadevs.gori.data.repository.dataSource.AuthRemoteDataSource
import com.mustadevs.gori.data.repository.dataSource.UsersRemoteDataSource
import com.mustadevs.gori.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.mustadevs.gori.data.repository.dataSourceImpl.UsersRemoteDataSourceImpl
import com.mustadevs.gori.data.service.AuthService
import com.mustadevs.gori.data.service.UsersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    fun provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource = AuthRemoteDataSourceImpl(authService)

    @Provides
    fun provideUsersRemoteDataSource(usersService: UsersService): UsersRemoteDataSource = UsersRemoteDataSourceImpl(usersService)
}