package com.mubaiwa.trust.umkhathi.feature.weather.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.mubaiwa.trust.umkhathi.common.utils.LocationInfo

class HomeViewModel @ViewModelInject constructor( private val locationInfo: LocationInfo) : ViewModel() {

    fun requestDeviceLocation() {
        locationInfo.requestLocation()
    }

}