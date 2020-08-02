package com.mubaiwa.trust.umkhathi.feature.weather.util

import com.mubaiwa.trust.umkhathi.feature.weather.models.DataItemEntity
import com.mubaiwa.trust.umkhathi.feature.weather.models.HourModel
import com.mubaiwa.trust.umkhathi.feature.weather.models.WeatherResponseEntity

class HourMapper : EntityMapper<DataItemEntity, HourModel> {

    private var timeZone: String? = null

    override fun mapFromEntity(entity: DataItemEntity): HourModel {
        return HourModel(
                time = entity.time,
                summary = entity.summary,
                temperature = entity.temperature,
                icon = entity.icon,
                timezone = timeZone
        )
    }

    override fun mapFromDomain(domain: HourModel): DataItemEntity {
        return DataItemEntity()
    }

    fun mapEntityList(weather: WeatherResponseEntity): List<HourModel>? {
        timeZone = weather.timezone
        return weather.hourly.data?.map { mapFromEntity(it) }
    }
}