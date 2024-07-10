package com.example.weatherappdagger.core.data.repository.weather_repository

import com.example.weatherappdagger.core.data.network.api.RetrofitWeatherApi
import com.example.weatherappdagger.core.data.model.WeatherDataModel
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: RetrofitWeatherApi
) : WeatherRepository
{
    override suspend fun getWeatherData(city: String): WeatherDataModel {
        return weatherApi.getWeatherData(q=city)
    }
}