package com.mubaiwa.trust.umkhathi.feature.models.weather

import com.google.gson.annotations.SerializedName

data class WeatherResponseModel(@SerializedName("currently")
                                val currently: Currently,
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
                                val hourly: Hourly,
                                @SerializedName("longitude")
                                val longitude: Double = 0.0)