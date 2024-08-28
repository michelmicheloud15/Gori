package com.mustadevs.gori.di

import com.mustadevs.gori.data.dataSource.local.AuthLocalDataSource
import com.mustadevs.gori.data.dataSource.local.AuthLocalDataSourceImpl
import com.mustadevs.gori.data.dataSource.local.CategoriesLocalDataSource
import com.mustadevs.gori.data.dataSource.local.CategoriesLocalDataSourceImpl
import com.mustadevs.gori.data.dataSource.local.dao.CategoriesDao
import com.mustadevs.gori.data.dataSource.local.datastore.AuthDatastore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    fun provideAuthLocalDataSource(authDatastore: AuthDatastore): AuthLocalDataSource = AuthLocalDataSourceImpl(authDatastore)

    @Provides
    fun provideCategoriesLocalDataSource(categoriesDao: CategoriesDao): CategoriesLocalDataSource = CategoriesLocalDataSourceImpl(categoriesDao)
}