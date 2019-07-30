package com.hiczp.spaceengineers.remoteapi.service

import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("apiVersion")
    val apiVersion: String,
    @SerializedName("queryTime")
    val queryTime: Float
)

open class CommonResponse(
    @SerializedName("meta")
    val meta: Meta = Meta("1.0", 0f)
)
