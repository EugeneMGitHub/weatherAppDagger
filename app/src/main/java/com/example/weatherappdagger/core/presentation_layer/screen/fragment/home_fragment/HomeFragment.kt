package com.example.weatherappdagger.core.presentation_layer.screen.fragment.home_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import com.example.weatherappdagger.core.App
import com.example.weatherappdagger.core.data.model.Computer
import com.example.weatherappdagger.core.data.repository.weather_repository.WeatherRepository
import com.example.weatherappdagger.databinding.FragmentHomeBinding
import javax.inject.Inject

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
//    private val viewModel: HomeViewModel by activityViewModels()

    @Inject
    lateinit var weatherRepository: WeatherRepository

    @Inject
    lateinit var computer: Computer

    private val viewModel: HomeViewModel by viewModels {
        HomeViewModel.HomeViewModelFactory(weatherRepository, computer)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as App).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.computerVM.observe(activity as LifecycleOwner){
            binding.textViewId.text = it
        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

}