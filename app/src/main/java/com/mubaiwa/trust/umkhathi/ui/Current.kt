package com.mubaiwa.trust.umkhathi.ui

import com.mubaiwa.trust.umkhathi.Weather.Forecast
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by trust on 2016/01/30.
 */
class Current {
    var icon: String? = null
    var time: Long = 0
    private var mTemperature = 0.0
    var humidity = 0.0
    private var mPrecipitation = 0.0
    var summary: String? = null
    var timeZone: String? = null

    val iconId: Int
        get() = Forecast.getIconId(icon ?: "")

    val formattedTime: String
        get() {
            val formatter = SimpleDateFormat("h:mm a")
            formatter.timeZone = TimeZone.getTimeZone(timeZone)
            val dateTime = Date(time * 1000)
            return formatter.format(dateTime)
        }

    val temperature: Int
        get() = Math.round(mTemperature).toInt()

    fun setTemperature(temperature: Double) {
        mTemperature = temperature
    }

    val precipitation: Int
        get() {
            val precipPrecentage = mPrecipitation * 100
            return Math.round(precipPrecentage).toInt()
        }

    fun setPrecipitation(precipitation: Double) {
        mPrecipitation = precipitation
    }

}