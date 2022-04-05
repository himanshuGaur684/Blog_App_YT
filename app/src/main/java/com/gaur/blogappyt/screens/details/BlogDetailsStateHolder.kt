package com.gaur.blogappyt.screens.details

import com.gaur.domain.model.Blog

data class BlogDetailsStateHolder(
    val isLoading: Boolean = false,
    val data: Blog? = null,
    val error: String = ""
)