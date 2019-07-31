package com.hiczp.spaceengineers.remoteapi.service.server

import com.hiczp.caeruleum.annotation.Delete
import com.hiczp.caeruleum.annotation.Get
import com.hiczp.spaceengineers.remoteapi.service.NoDataResponse
import com.hiczp.spaceengineers.remoteapi.service.NoInnerResponse
import com.hiczp.spaceengineers.remoteapi.service.Response

interface ServerService {
    @Get("server")
    suspend fun serverStatus(): NoInnerResponse<Status>

    @Delete("server")
    suspend fun stopServer(): NoDataResponse

    @Get("server/ping")
    suspend fun ping(): Response<String>
}
