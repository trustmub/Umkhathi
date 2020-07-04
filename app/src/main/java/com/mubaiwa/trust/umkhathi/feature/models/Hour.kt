package com.mubaiwa.trust.umkhathi.feature.models

/**
 * Created by trust on 2016/02/01.
 */
data class Hour(
        var time: Long = 0,
        var summary: String? = null,
        var temperature: Double = 0.0,
        var icon: String? = null,
        var timezone: String? = null
)