package com.example.github.repository

import com.example.github.data.RetrofitService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppRepositoryModule {

    @Provides
    @Singleton
    fun provideAppRepository(
        retrofitService: RetrofitService
    ): AppRepository = AppRepositoryImpl(retrofitService)
}