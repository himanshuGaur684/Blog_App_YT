package com.gaur.domain.repository

import com.gaur.domain.model.Blog

interface GetBlogsRepository {

    suspend fun getBlogs():List<Blog>

}