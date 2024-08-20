package com.mustadevs.gori.data.repository.dataSourceImpl

import com.mustadevs.gori.data.repository.dataSource.CategoriesRemoteDataSource
import com.mustadevs.gori.data.service.CategoriesService
import com.mustadevs.gori.domain.model.Category
import com.mustadevs.gori.domain.model.User
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response
import java.io.File

class CategoriesRemoteDataSourceImpl(private val categoriesService: CategoriesService):
    CategoriesRemoteDataSource {

    override suspend fun create(category: Category, file: File): Response<Category> {
        val connection = file.toURI().toURL().openConnection()
        val mimeType = connection.contentType // "image/png or image/jpg"
        val contentType = "text/plain"
        val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
        val fileFormData = MultipartBody.Part.createFormData("file", file.name, requestFile)
        val nameData = category.name.toRequestBody(contentType.toMediaTypeOrNull())
        val descriptionData = category.description.toRequestBody(contentType.toMediaTypeOrNull())

        return categoriesService.create(fileFormData, nameData, descriptionData)
    }

    override suspend fun getCategories(): Response<List<Category>> = categoriesService.getCategories()

    override suspend fun update(id: String, category: Category): Response<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun updateWithImage(id: String, user: User, file: File): Response<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String): Response<Unit> {
        TODO("Not yet implemented")
    }

}