package com.gaur.data.repository

import com.gaur.common.Resource
import com.gaur.data.mappers.toDomain
import com.gaur.data.network.ApiService
import com.gaur.domain.model.Blog
import com.gaur.domain.repository.GetPagerBlogsRepo
import javax.inject.Inject

class GetPagerBlogsRepoImpl @Inject constructor(private val apiService: ApiService) :
    GetPagerBlogsRepo {

    override suspend fun getPagerBlogs(page: Int, limit: Int): Resource<List<Blog>> {
        return try {
            val response = apiService.getBlogsPagination(page = page, limit = limit)
            if (response.isSuccessful) {
                val body = response.body()?.data?.toDomain()
                Resource.Success(body)

            } else {
                Resource.Error(response.errorBody()?.string())
            }

        } catch (e: Exception) {
            Resource.Error(e.localizedMessage)
        }
    }
}