package com.mubaiwa.trust.umkhathi.common

import androidx.annotation.IntDef
import com.mubaiwa.trust.umkhathi.common.AppConstants.Permission.LOCATION_REQUEST_CODE

@IntDef(LOCATION_REQUEST_CODE)
@Retention(AnnotationRetention.SOURCE)
annotation class AppConstants {

    object Permission {
        const val LOCATION_REQUEST_CODE = 103
    }
}