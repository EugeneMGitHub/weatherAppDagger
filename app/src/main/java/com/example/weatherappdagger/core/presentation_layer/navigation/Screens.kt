package com.example.weatherappdagger.core.presentation_layer.navigation
import com.example.weatherappdagger.core.presentation_layer.screen.fragment.home_fragment.HomeFragment
import com.example.weatherappdagger.core.presentation_layer.screen.fragment.moscowFragment.MoscowFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen


object Screens {
    fun home() = FragmentScreen {HomeFragment()}
    fun moscowFramgnet() = FragmentScreen { MoscowFragment() }
}