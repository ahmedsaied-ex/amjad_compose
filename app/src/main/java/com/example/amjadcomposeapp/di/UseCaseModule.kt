package com.example.amjadcomposeapp.di

import com.example.amjadcomposeapp.domain.repository.RequestsRepository
import com.example.amjadcomposeapp.domain.use_case.GetRequestsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetRequestsUseCase(repository: RequestsRepository): GetRequestsUseCase {
        return GetRequestsUseCase(repository)
    }
}
