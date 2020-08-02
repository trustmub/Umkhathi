package com.mubaiwa.trust.umkhathi.feature.weather.util

interface EntityMapper<Entity, DomainModel> {

    fun mapFromEntity(entity: Entity): DomainModel

    fun mapFromDomain(domain: DomainModel): Entity
}