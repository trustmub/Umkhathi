package com.mubaiwa.trust.umkhathi.common.di

import com.mubaiwa.trust.umkhathi.common.services.networking.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
open class NetworkModule {

    @Provides
    @Singleton
    fun provideNetworkServices(): WeatherService {
        return Retrofit.Builder()
                .baseUrl("https://api.forecast.io/forecast/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherService::class.java)
    }
}