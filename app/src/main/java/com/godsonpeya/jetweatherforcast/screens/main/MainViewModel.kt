package com.godsonpeya.jetweatherforcast.screens.main

import androidx.lifecycle.ViewModel
import com.godsonpeya.jetweatherforcast.data.DataOrException
import com.godsonpeya.jetweatherforcast.model.Weather
import com.godsonpeya.jetweatherforcast.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: WeatherRepository) : ViewModel() {


    suspend fun getWeather(city: String): DataOrException<Weather, Boolean, Exception> {
        return repository.getWeather(cityQuery = city)
    }

}
