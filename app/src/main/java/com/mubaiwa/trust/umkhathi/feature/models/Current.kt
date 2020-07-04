package com.mubaiwa.trust.umkhathi.feature.models

data class Current(
        var icon: String? = null,
        var time: Long = 0,
        var temperature: Double = 0.0,
        var humidity: Double = 0.0,
        var precipitation: Double = 0.0,
        var summary: String? = null,
        var timeZone: String? = null
)