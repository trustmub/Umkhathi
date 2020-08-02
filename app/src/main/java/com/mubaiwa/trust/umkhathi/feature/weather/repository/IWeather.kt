package com.mubaiwa.trust.umkhathi.feature.weather.repository

import com.mubaiwa.trust.umkhathi.feature.weather.models.WeatherResponseEntity

interface IWeather {

    fun fetchWeather(): WeatherResponseEntity?
}