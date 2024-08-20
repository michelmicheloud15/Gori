package com.mustadevs.gori.data.repository.dataSource

import com.mustadevs.gori.domain.model.Category
import com.mustadevs.gori.domain.model.User
import retrofit2.Response
import java.io.File

interface CategoriesRemoteDataSource {

    suspend fun create(category: Category, file: File): Response<Category>
    suspend fun getCategories(): Response<List<Category>>
    suspend fun update(id: String, category: Category): Response<Category>
    suspend fun updateWithImage(id: String, user: User, file: File): Response<Category>
    suspend fun delete(id: String): Response<Unit>

}