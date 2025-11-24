package com.example.amjadcomposeapp.di

import com.example.amjadcomposeapp.data.repository.AttendanceRepositoryImp
import com.example.amjadcomposeapp.domain.repository.AttendanceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AttendanceRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAttendanceRepository(
        impl: AttendanceRepositoryImp
    ): AttendanceRepository

}
