package com.example.amjadcomposeapp.di

import com.example.amjadcomposeapp.data.local.dataSource.MediaDataSource
import com.example.amjadcomposeapp.data.local.dataSource.MediaDataSourceImp
import com.example.amjadcomposeapp.data.repository.MediaRepositoryImpl
import com.example.amjadcomposeapp.domain.repository.MediaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MediaModule {

    @Provides
    @Singleton
    fun provideMediaDataSource(): MediaDataSource = MediaDataSourceImp()

    @Provides
    @Singleton
    fun provideMediaRepository(
        dataSource: MediaDataSource
    ): MediaRepository = MediaRepositoryImpl(dataSource)
}
