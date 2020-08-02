package com.mubaiwa.trust.umkhathi.feature.weather.util

import com.mubaiwa.trust.umkhathi.feature.weather.models.CurrentModel
import com.mubaiwa.trust.umkhathi.feature.weather.models.CurrentlyEntity

class CurrentMapper : EntityMapper<CurrentlyEntity, CurrentModel> {

    private var timeZone: String? = null

    override fun mapFromEntity(entity: CurrentlyEntity): CurrentModel {
        return CurrentModel(
                icon = entity.icon,
                time = entity.time,
                temperature = entity.temperature,
                humidity = entity.humidity,
                precipitation = entity.precipIntensity,
                summary = entity.summary,
                timeZone = timeZone
        )
    }

    override fun mapFromDomain(domain: CurrentModel): CurrentlyEntity {
        return CurrentlyEntity()
    }

    fun setTimeZone(tZone: String?) {
        timeZone = tZone
    }

}