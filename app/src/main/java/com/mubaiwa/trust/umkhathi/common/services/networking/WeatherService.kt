package com.mubaiwa.trust.umkhathi.common.services.networking

import com.mubaiwa.trust.umkhathi.feature.models.weather.WeatherResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface WeatherService {

    @GET("https://api.forecast.io/forecast/")
    suspend fun getWeather(): Response<WeatherResponseModel>

}