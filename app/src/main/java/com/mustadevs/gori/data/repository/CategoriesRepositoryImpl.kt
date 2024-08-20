package com.mustadevs.gori.data.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import com.mustadevs.gori.data.repository.dataSource.CategoriesRemoteDataSource
import com.mustadevs.gori.domain.model.Category
import com.mustadevs.gori.domain.repository.CategoriesRepository
import com.mustadevs.gori.domain.util.Resource
import com.mustadevs.gori.domain.util.ResponseToRequest
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import java.io.File

class CategoriesRepositoryImpl(private val categoriesRemoteDataSource: CategoriesRemoteDataSource): CategoriesRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun create(category: Category, file: File): Resource<Category> = ResponseToRequest.send(
        categoriesRemoteDataSource.create(category, file)
    )

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun getCategories(): Flow<Resource<List<Category>>> = callbackFlow{
        trySend(ResponseToRequest.send(categoriesRemoteDataSource.getCategories())) //como hay flow, asi se envia datos a traves de flow
        awaitClose{
            cancel()
        }
    }

    override suspend fun update(id: String, category: Category): Resource<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun updateWithImage(
        id: String,
        category: Category,
        file: File
    ): Resource<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String): Resource<Unit> {
        TODO("Not yet implemented")
    }
}