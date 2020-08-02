package com.mubaiwa.trust.umkhathi.feature.weather.models

data class CurrentModel(
        var icon: String? = null,
        var time: Long = 0,
        var temperature: Double = 0.0,
        var humidity: Double = 0.0,
        var precipitation: Double = 0.0,
        var summary: String? = null,
        var timeZone: String? = null
)