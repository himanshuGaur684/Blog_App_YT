package com.gaur.domain.di

import com.gaur.domain.repository.GetBlogsRepository
import com.gaur.domain.use_cases.GetBlogsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {



    @Provides
    fun provideGetBlogsUseCase(getBlogsRepository: GetBlogsRepository):GetBlogsUseCase{
        return GetBlogsUseCase(getBlogsRepository)
    }

}