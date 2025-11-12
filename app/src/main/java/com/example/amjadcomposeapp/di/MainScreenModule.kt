package com.example.amjadcomposeapp.di

import com.example.amjadcomposeapp.data.local.dataSource.*
import com.example.amjadcomposeapp.data.repository.MainScreenRepositoryImp
import com.example.amjadcomposeapp.domain.repository.MainScreenRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MainScreenModule {

    // ✅ Bind all DataSource interfaces to their implementations
    @Binds
    @Singleton
    abstract fun bindAssessmentCardDataSource(
        impl: AssessmentCardDataSourceImp
    ): AssessmentCardDataSource

    @Binds
    @Singleton
    abstract fun bindBannerDataSource(
        impl: BannerDataSourceImp
    ): BannerDataSource

    @Binds
    @Singleton
    abstract fun bindHrRequestsDataSource(
        impl: HrRequestsDataSourceImp
    ): HrRequestsDataSource

    @Binds
    @Singleton
    abstract fun bindSurveyTapsDataSource(
        impl: SurveyTapsDataSourceImp
    ): SurveyTapsDataSource

    @Binds
    @Singleton
    abstract fun bindNewsDataSource(
        impl: NewsDataSourceImp
    ): NewsDataSource

    @Binds
    @Singleton
    abstract fun bindOfferCategoryDataSource(
        impl: OfferCategoryDataSourceImp
    ): OfferCategoryDataSource

    @Binds
    @Singleton
    abstract fun bindMostUsedOffersDataSource(
        impl: MostUsedOffersDataSourceImp
    ): MostUsedOffersDataSource

    // ✅ Bind Repository
    @Binds
    @Singleton
    abstract fun bindMainScreenRepository(
        impl: MainScreenRepositoryImp
    ): MainScreenRepository

    @Binds
    @Singleton
    abstract fun bindBottomSheetRepository(
        impl: BottomSheetDataSourceImp
    ): BottomSheetDataSource
}
