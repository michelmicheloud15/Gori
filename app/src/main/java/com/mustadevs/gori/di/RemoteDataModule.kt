package com.mustadevs.gori.di

import com.mustadevs.gori.data.dataSource.remote.AuthRemoteDataSource
import com.mustadevs.gori.data.dataSource.remote.AuthRemoteDataSourceImpl
import com.mustadevs.gori.data.dataSource.remote.CategoriesRemoteDataSource
import com.mustadevs.gori.data.dataSource.remote.CategoriesRemoteDataSourceImpl
import com.mustadevs.gori.data.dataSource.remote.ProductsRemoteDataSource
import com.mustadevs.gori.data.dataSource.remote.ProductsRemoteDataSourceImpl
import com.mustadevs.gori.data.dataSource.remote.UsersRemoteDataSource
import com.mustadevs.gori.data.dataSource.remote.UsersRemoteDataSourceImpl
import com.mustadevs.gori.data.dataSource.remote.service.AuthService
import com.mustadevs.gori.data.dataSource.remote.service.CategoriesService
import com.mustadevs.gori.data.dataSource.remote.service.ProductsService
import com.mustadevs.gori.data.dataSource.remote.service.UsersService
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

    @Provides
    fun provideCategoriesRemoteDataSource(categoriesService: CategoriesService): CategoriesRemoteDataSource = CategoriesRemoteDataSourceImpl(categoriesService)

    @Provides
    fun provideProductsRemoteDataSource(productsService: ProductsService): ProductsRemoteDataSource = ProductsRemoteDataSourceImpl(productsService)

}