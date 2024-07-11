package com.example.weatherappdagger.core.di.component

import com.example.weatherappdagger.core.data.model.Computer
import com.example.weatherappdagger.core.di.module.ComputerModule
import com.example.weatherappdagger.core.di.module.NetworkModule
import com.example.weatherappdagger.core.di.module.RepositoryModule
import com.example.weatherappdagger.core.presentation_layer.screen.activity.main.MainActivity
import com.example.weatherappdagger.core.presentation_layer.screen.fragment.home_fragment.HomeFragment
import com.example.weatherappdagger.core.presentation_layer.screen.fragment.moscowFragment.MoscowFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ComputerModule::class,
    NetworkModule::class,
    RepositoryModule::class
])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: MoscowFragment)
    fun inject(fragment: HomeFragment)
    fun computer(): Computer
}
