package com.example.weatherappdagger.core.presentation_layer.navigation
import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.example.weatherappdagger.core.presentation_layer.screen.fragment.moscowFragment.MoscowFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen


object Screens {
    fun moscowFramgnet() = FragmentScreen { MoscowFragment() }
}