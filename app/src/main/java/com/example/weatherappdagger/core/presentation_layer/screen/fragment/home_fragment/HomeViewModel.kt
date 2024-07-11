package com.example.weatherappdagger.core.presentation_layer.screen.fragment.home_fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherappdagger.core.data.model.Computer
import com.example.weatherappdagger.core.data.repository.weather_repository.WeatherRepository

class HomeViewModel(
    private val weatherRepository: WeatherRepository,
    private val computer: Computer
): ViewModel() {

    val computerVM: MutableLiveData<String> = MutableLiveData(computer.toString())


    class HomeViewModelFactory(
        private val weatherRepository: WeatherRepository,
        private val computer: Computer
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HomeViewModel(weatherRepository, computer) as T
        }
    }

}