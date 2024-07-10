package com.example.weatherappdagger.core

import android.app.Application
import com.example.weatherappdagger.core.di.component.AppComponent
import com.example.weatherappdagger.core.di.component.DaggerAppComponent
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router

class App : Application() {

    companion object {
        lateinit var cicerone: Cicerone<Router>
        lateinit var navigatorHolder: NavigatorHolder
        lateinit var router: Router
    }

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()

        cicerone = Cicerone.create()
        navigatorHolder = cicerone.getNavigatorHolder()
        router = cicerone.router
    }

}