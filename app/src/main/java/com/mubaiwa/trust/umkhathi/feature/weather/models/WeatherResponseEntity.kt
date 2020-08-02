package com.mubaiwa.trust.umkhathi.feature.weather.models


import com.google.gson.annotations.SerializedName

data class WeatherResponseEntity(
        @SerializedName("currently")
        val currently: CurrentlyEntity,
        @SerializedName("offset")
        val offset: Int = 0,
        @SerializedName("timezone")
        val timezone: String = "",
        @SerializedName("latitude")
        val latitude: Double = 0.0,
        @SerializedName("daily")
        val daily: Daily,
        @SerializedName("flags")
        val flags: Flags,
        @SerializedName("hourly")
        val hourly: HourlyEntity,
        @SerializedName("longitude")
        val longitude: Double = 0.0)

data class CurrentlyEntity(
        @SerializedName("summary")
        val summary: String = "",
        @SerializedName("precipProbability")
        val precipProbability: Double = 0.0,
        @SerializedName("visibility")
        val visibility: Int = 0,
        @SerializedName("windGust")
        val windGust: Double = 0.0,
        @SerializedName("precipIntensity")
        val precipIntensity: Double = 0.0,
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
        val ozone: Double = 0.0,
        @SerializedName("precipType")
        val precipType: String = "",
        @SerializedName("temperature")
        val temperature: Double = 0.0,
        @SerializedName("humidity")
        val humidity: Double = 0.0,
        @SerializedName("time")
        val time: Long = 0,
        @SerializedName("windSpeed")
        val windSpeed: Double = 0.0,
        @SerializedName("uvIndex")
        val uvIndex: Int = 0)


data class Daily(
        @SerializedName("summary")
        val summary: String = "",
        @SerializedName("data")
        val data: List<DataItemEntity>?,
        @SerializedName("icon")
        val icon: String = "")


data class DataItemEntity(
        @SerializedName("summary")
        val summary: String = "",
        @SerializedName("precipProbability")
        val precipProbability: Double = 0.0,
        @SerializedName("visibility")
        val visibility: Int = 0,
        @SerializedName("windGust")
        val windGust: Double = 0.0,
        @SerializedName("precipIntensity")
        val precipIntensity: Double = 0.0,
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
        val ozone: Double = 0.0,
        @SerializedName("precipType")
        val precipType: String = "",
        @SerializedName("temperature")
        val temperature: Double = 0.0,
        @SerializedName("humidity")
        val humidity: Double = 0.0,
        @SerializedName("time")
        val time: Long = 0,
        @SerializedName("windSpeed")
        val windSpeed: Double = 0.0,
        @SerializedName("uvIndex")
        val uvIndex: Int = 0)


data class Flags(
        @SerializedName("nearest-station")
        val nearestStation: Double = 0.0,
        @SerializedName("sources")
        val sources: List<String>?,
        @SerializedName("units")
        val units: String = "")


data class HourlyEntity(
        @SerializedName("summary")
        val summary: String = "",
        @SerializedName("data")
        val data: List<DataItemEntity>?,
        @SerializedName("icon")
        val icon: String = "")

