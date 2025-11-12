package com.example.amjadcomposeapp.di

import com.example.amjadcomposeapp.data.local.dataSource.EmojisDataSource
import com.example.amjadcomposeapp.data.local.dataSource.EmojisDataSourceImp
import com.example.amjadcomposeapp.data.local.dataSource.RequestsDataSource
import com.example.amjadcomposeapp.data.local.dataSource.RequestsDataSourceImp
import com.example.amjadcomposeapp.data.repository.RequestsRepositoryImp
import com.example.amjadcomposeapp.domain.repository.RequestsRepository
import com.example.amjadcomposeapp.domain.use_case.GetRequestsUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RequestsModule {

    // Bind DataSource interface to its implementation
    @Binds
    @Singleton
    abstract fun bindRequestsDataSource(
        impl: RequestsDataSourceImp
    ): RequestsDataSource

    // Bind Repository interface to its implementation
    @Binds
    @Singleton
    abstract fun bindRequestsRepository(
        impl: RequestsRepositoryImp
    ): RequestsRepository
}
