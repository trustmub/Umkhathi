package com.mubaiwa.trust.umkhathi.feature.weather.util

import com.mubaiwa.trust.umkhathi.feature.weather.models.DataItemEntity
import com.mubaiwa.trust.umkhathi.feature.weather.models.DayModel
import com.mubaiwa.trust.umkhathi.feature.weather.models.WeatherResponseEntity

class DayMapper : EntityMapper<DataItemEntity, DayModel> {

    private var timeZone: String? = null

    override fun mapFromEntity(entity: DataItemEntity): DayModel {
        return DayModel(
                time = entity.time,
                summary = entity.summary,
                temperatureMax = entity.temperature,
                icon = entity.icon,
                timezone = timeZone
        )
    }

    override fun mapFromDomain(domain: DayModel): DataItemEntity {
        return DataItemEntity()
    }

    fun mapEntityList(weather: WeatherResponseEntity): List<DayModel>? {
        timeZone = weather.timezone
        return weather.daily.data?.map { mapFromEntity(it) }
    }

}
