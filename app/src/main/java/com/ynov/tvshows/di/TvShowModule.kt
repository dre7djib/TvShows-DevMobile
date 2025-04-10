package com.ynov.tvshows.di

import android.provider.SyncStateContract
import com.ynov.tvshows.most_popular.data.repository.MostPopularRepositoryImpl
import com.ynov.tvshows.most_popular.data.service.MostPopularService
import com.ynov.tvshows.most_popular.domain.repository.MostPopularRepository
import com.ynov.tvshows.most_popular.domain.useCase.MostPopularUseCase
import com.ynov.tvshows.show_details.data.repository.ShowDetailsRepositoryImpl
import com.ynov.tvshows.show_details.data.service.ShowDetailsService
import com.ynov.tvshows.show_details.domain.repository.ShowDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.ynov.tvshows.utils.Constants
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(SingletonComponent::class)
object NewsModule {

    @Provides
    @Singleton
    fun provideEverythingService() : MostPopularService {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MostPopularService::class.java)
    }

    @Provides
    @Singleton
    fun provideEverythingRepository(service: MostPopularService) : MostPopularRepository {
        return MostPopularRepositoryImpl(service)
    }

    @Provides
    @Singleton
    fun provideEverythingUseCase(repository: MostPopularRepository): MostPopularUseCase {
        return MostPopularUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideShowDetailsRepository(apiService: ShowDetailsService): ShowDetailsRepository  {
        return ShowDetailsRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideShowDetailsService(): ShowDetailsService {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ShowDetailsService::class.java)
    }
}