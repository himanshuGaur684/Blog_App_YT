package com.gaur.domain.repository

import com.gaur.common.Resource
import com.gaur.domain.model.Blog

interface GetPagerBlogsRepo {

    suspend fun getPagerBlogs(page: Int, limit: Int): Resource<List<Blog>>

}