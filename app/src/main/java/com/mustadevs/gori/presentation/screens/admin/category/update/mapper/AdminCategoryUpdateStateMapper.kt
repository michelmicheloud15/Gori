package com.mustadevs.gori.presentation.screens.admin.category.update.mapper

import com.mustadevs.gori.domain.model.Category
import com.mustadevs.gori.presentation.screens.admin.category.update.AdminCategoryUpdateState

fun AdminCategoryUpdateState.toCategory(): Category {
    return Category(
        name = name,
        description = description
    )
}