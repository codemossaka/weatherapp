package com.godsonpeya.jetweatherforcast.repository

import android.util.Log
import com.godsonpeya.jetweatherforcast.data.DataOrException
import com.godsonpeya.jetweatherforcast.model.Weather
import com.godsonpeya.jetweatherforcast.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi) {

    suspend fun getWeather(cityQuery: String):DataOrException<Weather, Boolean, Exception>{

        val response = try{
            api.getWeather(query = cityQuery)
        }catch (e:Exception){
            Log.d("WeatherRepository", "getWeather $e")
            return DataOrException(e=e)
        }
        return DataOrException(data = response)
    }
}