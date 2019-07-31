package com.hiczp.spaceengineers.remoteapi.service

import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("apiVersion")
    val apiVersion: String,
    @SerializedName("queryTime")
    val queryTime: Float
)

open class NoDataResponse(
    @SerializedName("meta")
    val meta: Meta
)

open class Response<T>(
    @SerializedName("data")
    val data: T,
    meta: Meta
) : NoDataResponse(meta)

open class NoInnerResponse<T>(
    data: T,
    meta: Meta
) : Response<T>(data, meta)
