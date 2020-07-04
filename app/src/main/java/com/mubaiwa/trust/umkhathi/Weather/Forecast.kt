package com.mubaiwa.trust.umkhathi.Weather

import com.mubaiwa.trust.umkhathi.R
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
            if (iconString == "clear-day") {
                iconId = R.mipmap.clear_day
            } else if (iconString == "clear-night") {
                iconId = R.mipmap.clear_night
            } else if (iconString == "rain") {
                iconId = R.mipmap.rain
            } else if (iconString == "snow") {
                iconId = R.mipmap.snow
            } else if (iconString == "sleet") {
                iconId = R.mipmap.sleet
            } else if (iconString == "wind") {
                iconId = R.mipmap.wind
            } else if (iconString == "fog") {
                iconId = R.mipmap.fog
            } else if (iconString == "cloudy") {
                iconId = R.mipmap.cloudy
            } else if (iconString == "partly-cloudy-day") {
                iconId = R.mipmap.partly_cloudy
            } else if (iconString == "partly-cloudy-night") {
                iconId = R.mipmap.cloudy_night
            }
            return iconId
        }
    }
}