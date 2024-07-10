package com.example.weatherappdagger.core.di.module

import com.example.weatherappdagger.core.data.network.api.RetrofitWeatherApi
import com.example.weatherappdagger.core.data.repository.weather_repository.WeatherRepository
import com.example.weatherappdagger.core.data.repository.weather_repository.WeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RepositoryModule {
    @Provides
    @Singleton
    fun provideWeatherRepository(
        weatherApi: RetrofitWeatherApi
    ): WeatherRepository {
        return WeatherRepositoryImpl(weatherApi = weatherApi)
    }
}