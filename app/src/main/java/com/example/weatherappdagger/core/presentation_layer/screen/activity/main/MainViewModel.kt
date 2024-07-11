package com.example.weatherappdagger.core.presentation_layer.screen.activity.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.weatherappdagger.core.data.repository.weather_repository.WeatherRepository
import com.example.weatherappdagger.core.presentation_layer.navigation.Navigation
import com.example.weatherappdagger.core.presentation_layer.navigation.Screens
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

class MainViewModel(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    init{
        openFirstScreen()
    }
    val randomText: MutableLiveData<String> = MutableLiveData("FirstValue")
    val cityWeather: MutableLiveData<String> = MutableLiveData("NoWeatherGotten")

    private fun openFirstScreen() {
        val firstScreen = Screens.home()
        Navigation.getRouter().newRootScreen(firstScreen)
    }

    private fun getWeather(city: String){
     viewModelScope.launch {
         try{
             val serverResponse = weatherRepository.getWeatherData(city = city)
             cityWeather.value = serverResponse.current.temp_c.toString()
             Log.d("MainViewModelLog", serverResponse.toString())
         }catch (e: retrofit2.HttpException){
             val message = if (e.localizedMessage != null) "Произошла ошибка ${e.localizedMessage}. \n Проверьте интернет-соединение и повторите попытку." else "Произошла неожиданная ошибка. Проверьте интернет-соединение и повторите попытку."
             Log.e("MainViewModelLog", message)
         }catch (e : IOException){
             Log.e("MainViewModelLog", "Проверьте подключение к Интернету и повторите попытку.")
         }

     }

    }
    class Factory @Inject constructor(
        private val weatherRepository: WeatherRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(weatherRepository) as T
        }
    }
}