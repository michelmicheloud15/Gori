package com.mustadevs.gori.presentation.screens.admin.category.create.mapper

import com.mustadevs.gori.domain.model.Category
import com.mustadevs.gori.presentation.screens.admin.category.create.AdminCategoryCreateState

fun AdminCategoryCreateState.toCategory(): Category {
    return Category(
        name = name,
        description = description
    )
}