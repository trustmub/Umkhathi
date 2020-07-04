package com.mubaiwa.trust.umkhathi.feature.models.weather

import com.google.gson.annotations.SerializedName

data class Daily(@SerializedName("summary")
                 val summary: String = "",
                 @SerializedName("data")
                 val data: List<DataItem>?,
                 @SerializedName("icon")
                 val icon: String = "")