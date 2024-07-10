package com.example.weatherappdagger.core.di.module

import com.example.weatherappdagger.core.data.model.Computer
import dagger.Module
import dagger.Provides

@Module
object ComputerModule {
    @Provides
    fun provideComputer(): Computer {
        return Computer(name = "New1", price = "100$")
    }
}