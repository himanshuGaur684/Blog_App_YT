package com.gaur.data.repository

import com.gaur.data.mappers.toDomain
import com.gaur.data.network.ApiService
import com.gaur.data.network.utils.SafeApiRequest
import com.gaur.domain.model.Blog
import com.gaur.domain.model.Owner
import com.gaur.domain.repository.GetBlogDetailsRepo
import javax.inject.Inject

class GetBlogDetailsRepoImpl @Inject constructor(private val apiService: ApiService) :
    GetBlogDetailsRepo, SafeApiRequest() {
    override suspend fun getBlogDetails(id: String): Blog {
        val response = safeApiRequest { apiService.getBlogDetails(id = id) }

        val blog = Blog(
            id = response.id ?: "",
            image = response.image ?: "",
            likes = response.likes ?: 0,
            owner = response.owner?.toDomain() ?: Owner("", "", "", "", ""),
            publishDate = response.publishDate ?: "",
            tags = response.tags ?: emptyList(),
            text = response.text ?: ""
        )

        return blog
    }
}