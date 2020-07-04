package com.mubaiwa.trust.umkhathi.Weather

import android.os.Parcel
import android.os.Parcelable
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by trust on 2016/02/01.
 */
class Day : Parcelable {
    var time: Long = 0
    var summary: String? = null
    private var mTemperatureMax = 0.0
    var icon: String? = null
    var timezone: String? = null

    val temperatureMax: Int
        get() = Math.round(mTemperatureMax).toInt()

    fun setTemperatureMax(temperatureMax: Double) {
        mTemperatureMax = temperatureMax
    }

    val iconId: Int
        get() = Forecast.getIconId(icon ?: "")

    val dayOfTheWeek: String
        get() {
            val formatter = SimpleDateFormat("EEEE")
            formatter.timeZone = TimeZone.getTimeZone(timezone)
            val dateTime = Date(time * 1000)
            return formatter.format(dateTime)
        }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeLong(time)
        dest.writeString(summary)
        dest.writeDouble(mTemperatureMax)
        dest.writeString(icon)
        dest.writeString(timezone)
    }

    private constructor(`in`: Parcel) {
        time = `in`.readLong()
        summary = `in`.readString()
        mTemperatureMax = `in`.readDouble()
        icon = `in`.readString()
        timezone = `in`.readString()
    }

    constructor() {
        // this is default contructor to avoid the contructor error
    }

    companion object {
        val CREATOR: Parcelable.Creator<Day?> = object : Parcelable.Creator<Day?> {
            override fun createFromParcel(source: Parcel): Day? {
                return Day(source)
            }

            override fun newArray(size: Int): Array<Day?> {
                return arrayOfNulls(size)
            }
        }
    }
}