package com.mustadevs.gori.domain.useCase.categories

import com.mustadevs.gori.domain.repository.CategoriesRepository

class GetCategoriesUseCase(private val repository: CategoriesRepository) {

    suspend operator fun invoke() = repository.getCategories()
}