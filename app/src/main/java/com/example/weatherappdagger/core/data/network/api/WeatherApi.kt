package com.example.weatherappdagger.core.data.network.api

import com.example.weatherappdagger.core.data.model.WeatherDataModel
import com.example.weatherappdagger.core.utils.Constants.API_KEY
import com.example.weatherappdagger.core.utils.Constants.FORECAST_END_POINT
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitWeatherApi {
    @GET(FORECAST_END_POINT)
    suspend fun getWeatherData(
        @Query("key") key: String = API_KEY,
        @Query("q") q: String,
        @Query("days") days: String = "8",
        @Query("aqi") aqi: String = "no",
        @Query("alerts") alerts: String = "no",
        @Query("lang") lang: String = "ru"
    ) : WeatherDataModel
}