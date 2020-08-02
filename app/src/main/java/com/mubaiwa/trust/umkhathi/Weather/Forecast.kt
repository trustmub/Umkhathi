package com.mubaiwa.trust.umkhathi.Weather

import com.mubaiwa.trust.umkhathi.R
import com.mubaiwa.trust.umkhathi.feature.weather.models.Hour
import com.mubaiwa.trust.umkhathi.ui.Current

/**
 * Created by trust on 2016/02/01.
 */
class Forecast {
    var current: Current? = null
    lateinit var hourlForecast: Array<Hour>
    lateinit var dailyForecast: Array<Day>

    companion object {
        fun getIconId(iconString: String): Int {
            var iconId = R.mipmap.clear_day
            when (iconString) {
                "clear-day" -> {
                    iconId = R.mipmap.clear_day
                }
                "clear-night" -> {
                    iconId = R.mipmap.clear_night
                }
                "rain" -> {
                    iconId = R.mipmap.rain
                }
                "snow" -> {
                    iconId = R.mipmap.snow
                }
                "sleet" -> {
                    iconId = R.mipmap.sleet
                }
                "wind" -> {
                    iconId = R.mipmap.wind
                }
                "fog" -> {
                    iconId = R.mipmap.fog
                }
                "cloudy" -> {
                    iconId = R.mipmap.cloudy
                }
                "partly-cloudy-day" -> {
                    iconId = R.mipmap.partly_cloudy
                }
                "partly-cloudy-night" -> {
                    iconId = R.mipmap.cloudy_night
                }
            }
            return iconId
        }
    }
}