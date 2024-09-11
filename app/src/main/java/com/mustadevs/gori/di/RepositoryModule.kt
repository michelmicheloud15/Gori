package com.mustadevs.gori.di

import com.mustadevs.gori.data.dataSource.local.AuthLocalDataSource
import com.mustadevs.gori.data.dataSource.local.CategoriesLocalDataSource
import com.mustadevs.gori.data.dataSource.local.ProductsLocalDataSource
import com.mustadevs.gori.data.dataSource.remote.AuthRemoteDataSource
import com.mustadevs.gori.data.dataSource.remote.CategoriesRemoteDataSource
import com.mustadevs.gori.data.dataSource.remote.ProductsRemoteDataSource
import com.mustadevs.gori.data.dataSource.remote.UsersRemoteDataSource
import com.mustadevs.gori.data.repository.AuthRepositoryImpl
import com.mustadevs.gori.data.repository.CategoriesRepositoryImpl
import com.mustadevs.gori.data.repository.ProductsRepositoryImpl
import com.mustadevs.gori.data.repository.UsersRepositoryImpl
import com.mustadevs.gori.domain.repository.AuthRepository
import com.mustadevs.gori.domain.repository.CategoriesRepository
import com.mustadevs.gori.domain.repository.ProductsRepository
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

    @Provides
    fun provideCategoriesRepository(
        categoriesRemoteDataSource: CategoriesRemoteDataSource,
        categoriesLocalDataSource: CategoriesLocalDataSource
    ): CategoriesRepository = CategoriesRepositoryImpl(categoriesRemoteDataSource, categoriesLocalDataSource)

    @Provides
    fun provideProductsRepository(
        productsRemoteDataSource: ProductsRemoteDataSource,
        productsLocalDataSource: ProductsLocalDataSource
    ): ProductsRepository = ProductsRepositoryImpl(productsRemoteDataSource, productsLocalDataSource)
}