package com.mustadevs.gori.domain.useCase.categories

import com.mustadevs.gori.domain.model.Category
import com.mustadevs.gori.domain.repository.CategoriesRepository
import java.io.File

class CreateCategoryUseCase(private val repository: CategoriesRepository) {

    suspend operator fun invoke(category: Category, file: File) = repository.create(category, file)
}