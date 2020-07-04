package com.mubaiwa.trust.umkhathi.feature.models

data class Day(
        var time: Long = 0,
        var summary: String? = null,
        var temperatureMax: Double = 0.0,
        var icon: String? = null,
        var timezone: String? = null
)