package com.example.amjadcomposeapp.di

import com.example.amjadcomposeapp.data.local.dataSource.AssessmentCardDataSource
import com.example.amjadcomposeapp.data.local.dataSource.AssessmentCardDataSourceImp
import com.example.amjadcomposeapp.data.local.dataSource.EmojisDataSource
import com.example.amjadcomposeapp.data.local.dataSource.EmojisDataSourceImp
import com.example.amjadcomposeapp.data.repository.DetailsScreenRepositoryImp

import com.example.amjadcomposeapp.domain.repository.DetailsScreenRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DetailsScreenModule {
    @Binds
    @Singleton
    abstract fun bindEmojis(
        impl: EmojisDataSourceImp
    ): EmojisDataSource

    @Binds
    @Singleton
    abstract fun bindDetailsScreenRepository(
        impl: DetailsScreenRepositoryImp
    ): DetailsScreenRepository


}