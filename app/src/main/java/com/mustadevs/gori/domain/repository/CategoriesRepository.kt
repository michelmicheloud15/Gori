package com.mustadevs.gori.domain.repository

import com.mustadevs.gori.domain.model.Category
import com.mustadevs.gori.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import java.io.File

interface CategoriesRepository {

    suspend fun create(category: Category, file: File): Resource<Category>
    fun getCategories(): Flow<Resource<List<Category>>>//se usa flow para cuando devuelve listas de categorias y no llega suspend
    suspend fun update(id: String, category: Category): Resource<Category>
    suspend fun updateWithImage(id: String, category: Category, file: File): Resource<Category>
    suspend fun delete(id: String): Resource<Unit>

}