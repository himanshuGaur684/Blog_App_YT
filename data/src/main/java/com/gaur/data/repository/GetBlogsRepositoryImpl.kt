package com.gaur.data.repository

import com.gaur.data.mappers.toDomain
import com.gaur.data.network.ApiService
import com.gaur.data.network.utils.SafeApiRequest
import com.gaur.domain.model.Blog
import com.gaur.domain.repository.GetBlogsRepository
import javax.inject.Inject

class GetBlogsRepositoryImpl @Inject constructor(private val apiService: ApiService): GetBlogsRepository , SafeApiRequest() {

    override suspend fun getBlogs(): List<Blog> {
        val response = safeApiRequest { apiService.getBlogs() }
        return response.data?.toDomain()?: emptyList()
    }
}