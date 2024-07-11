package com.example.weatherappdagger.core.presentation_layer.screen.activity.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.weatherappdagger.R
import com.example.weatherappdagger.core.App
import com.example.weatherappdagger.core.data.model.Computer
import com.example.weatherappdagger.databinding.ActivityMainBinding
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val navigator = AppNavigator(this, R.id.fragments_container)

    @Inject
    lateinit var computer: Computer

    @Inject
    lateinit var viewModelFactory: MainViewModel.Factory

    override fun onCreate(savedInstanceState: Bundle?) {

        (applicationContext as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]



//        viewModel.randomText.observe(this) { it ->
//            binding.textViewId.text = it
//        }

//        viewModel.cityWeather.observe(this){
//            binding.textViewId.text=it
//        }

    }


    override fun onResume() {
        super.onResume()
        App.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        App.navigatorHolder.removeNavigator()
        super.onPause()
    }
}