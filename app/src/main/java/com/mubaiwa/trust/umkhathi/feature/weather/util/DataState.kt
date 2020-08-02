package com.mubaiwa.trust.umkhathi.feature.weather.util

sealed class DataState<out R> {
    data class NetworkSuccess<out T>(val data: T) : DataState<T>()
    data class CacheSuccess<out T>(val data: T) : DataState<T>()
    data class NetworkError(val exception: Exception) : DataState<Nothing>()
    data class CacheError(val exception: Exception) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}