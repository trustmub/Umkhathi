package com.mubaiwa.trust.umkhathi.feature.models.weather

import com.google.gson.annotations.SerializedName

data class Flags(@SerializedName("nearest-station")
                 val nearestStation: Double = 0.0,
                 @SerializedName("sources")
                 val sources: List<String>?,
                 @SerializedName("units")
                 val units: String = "")