package com.example.weatherappdagger.core.data.repository.weather_repository

import com.example.weatherappdagger.core.data.model.WeatherDataModel

interface WeatherRepository {
    suspend fun getWeatherData(city: String): WeatherDataModel
}