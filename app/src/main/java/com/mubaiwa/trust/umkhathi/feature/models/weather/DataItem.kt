package com.mubaiwa.trust.umkhathi.feature.models.weather

import com.google.gson.annotations.SerializedName

data class DataItem(@SerializedName("summary")
                    val summary: String = "",
                    @SerializedName("precipProbability")
                    val precipProbability: Int = 0,
                    @SerializedName("visibility")
                    val visibility: Int = 0,
                    @SerializedName("windGust")
                    val windGust: Double = 0.0,
                    @SerializedName("precipIntensity")
                    val precipIntensity: Int = 0,
                    @SerializedName("icon")
                    val icon: String = "",
                    @SerializedName("cloudCover")
                    val cloudCover: Int = 0,
                    @SerializedName("windBearing")
                    val windBearing: Int = 0,
                    @SerializedName("apparentTemperature")
                    val apparentTemperature: Double = 0.0,
                    @SerializedName("pressure")
                    val pressure: Double = 0.0,
                    @SerializedName("dewPoint")
                    val dewPoint: Double = 0.0,
                    @SerializedName("ozone")
                    val ozone: Int = 0,
                    @SerializedName("temperature")
                    val temperature: Double = 0.0,
                    @SerializedName("humidity")
                    val humidity: Double = 0.0,
                    @SerializedName("time")
                    val time: Int = 0,
                    @SerializedName("windSpeed")
                    val windSpeed: Double = 0.0,
                    @SerializedName("uvIndex")
                    val uvIndex: Int = 0)