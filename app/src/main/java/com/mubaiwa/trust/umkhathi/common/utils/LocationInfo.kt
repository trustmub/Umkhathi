package com.mubaiwa.trust.umkhathi.common.utils

import android.annotation.SuppressLint
import android.content.Context
import android.os.Looper
import androidx.hilt.Assisted
import com.google.android.gms.location.*
import com.mubaiwa.trust.umkhathi.feature.models.DeviceLocation
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocationInfo @Inject constructor(@Assisted private val context: Context) {
    private val deviceLocation = DeviceLocation(
            latitude = 0F,
            longitude = 0F
    )
    private var locationRequest: LocationRequest = LocationRequest.create().apply {
        interval = 15000
        fastestInterval = 5000
        priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
    }

    private var locationCallback: LocationCallback
    private var fusedLocationClient: FusedLocationProviderClient

    init {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                if (locationResult != null) {
                    deviceLocation.latitude = locationResult.locations[0].latitude.toFloat()
                    deviceLocation.longitude = locationResult.locations[0].longitude.toFloat()
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    fun requestLocation() {
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper())
    }

    fun getLocation() = deviceLocation
}