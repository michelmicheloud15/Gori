package com.mustadevs.gori.di

import com.mustadevs.gori.data.datastore.AuthDatastore
import com.mustadevs.gori.data.repository.dataSource.AuthLocalDataSource
import com.mustadevs.gori.data.repository.dataSourceImpl.AuthLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    fun provideAuthLocalDataSource(authDatastore: AuthDatastore): AuthLocalDataSource = AuthLocalDataSourceImpl(authDatastore)
}