package com.example.weatherappdagger.core.presentation_layer.navigation

import com.example.weatherappdagger.core.App
import com.github.terrakok.cicerone.Router


object Navigation {
    fun getRouter(): Router {
    val screenRouter  = App.router
        return screenRouter
    }
}
