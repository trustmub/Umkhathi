package com.mubaiwa.trust.umkhathi.common.services.networking

import com.mubaiwa.trust.umkhathi.feature.models.weather.WeatherResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {

    @GET("{api_key}/{latitude},{longitude}")
    suspend fun getWeather(
            @Path("api_key") key: String = "",
            @Path("latitude") latitude: Double = 0.0,
            @Path("longitude") longitude: Double = 0.0
    ): Response<WeatherResponseModel>

}