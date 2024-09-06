package com.mustadevs.gori.domain.useCase.categories

data class CategoriesUseCase(
    val createCategory: CreateCategoryUseCase,
    val getCategories: GetCategoriesUseCase,
    val updateCategory: UpdateCategoryUseCase,
    val updateCategoryWithImage: UpdateCategoryWithImageUseCase,
    val deleteCategory: DeleteCategoryUseCase
)
