package com.example.weatherappdagger.core.di.module

import com.example.weatherappdagger.core.data.network.api.RetrofitWeatherApi
import com.example.weatherappdagger.core.utils.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val okHttpClient = OkHttpClient().newBuilder()
            .retryOnConnectionFailure(true)
            .callTimeout(3, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient) // добавляем OkHttpClient
            .build()
    }

    @Provides
    @Singleton
    fun provideWeatherApi(retrofit: Retrofit): RetrofitWeatherApi {
        return retrofit.create(RetrofitWeatherApi::class.java)
    }
}