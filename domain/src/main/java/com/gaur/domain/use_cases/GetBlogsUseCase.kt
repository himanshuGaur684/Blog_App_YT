package com.gaur.domain.use_cases

import com.gaur.common.Resource
import com.gaur.domain.model.Blog
import com.gaur.domain.repository.GetBlogsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetBlogsUseCase  @Inject constructor(private val getBlogsRepository: GetBlogsRepository){


     operator fun invoke() : Flow<Resource<List<Blog>>> = flow {
        emit(Resource.Loading(null))
        try {
            val response = getBlogsRepository.getBlogs()
            emit(Resource.Success(data = response))

        }catch (e:Exception){
            emit(Resource.Error("error occurred"))
        }

    }


}