package com.hiczp.spaceengineers.remoteapi.service.session.model

import com.google.gson.annotations.SerializedName
import com.hiczp.spaceengineers.remoteapi.service.CommonResponse

data class GetAsteroidsResponse(
    @SerializedName("data")
    val data: Data
) : CommonResponse() {
    data class Data(
        val asteroids: List<Asteroid>
    )
}
