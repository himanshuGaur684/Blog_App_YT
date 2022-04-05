package com.gaur.domain.use_cases

import com.gaur.common.Resource
import com.gaur.domain.model.Blog
import com.gaur.domain.repository.GetBlogDetailsRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetBlogDetailsUseCase @Inject constructor(private val getBlogDetailsRepo: GetBlogDetailsRepo) {


    operator fun invoke(id: String): Flow<Resource<Blog>> = flow {
        emit(Resource.Loading(""))
        try {
            val response = getBlogDetailsRepo.getBlogDetails(id)
            emit(Resource.Success(data = response))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }


    }

}