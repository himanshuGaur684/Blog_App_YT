package com.gaur.domain.repository

import com.gaur.domain.model.Blog

interface GetBlogDetailsRepo {

    suspend fun getBlogDetails(id: String): Blog

}