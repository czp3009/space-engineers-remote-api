package com.hiczp.spaceengineers.remoteapi.service.server

import com.google.gson.JsonElement
import com.hiczp.caeruleum.annotation.Delete
import com.hiczp.caeruleum.annotation.Get

interface ServerService {
    @Get("server")
    suspend fun serverStatus(): JsonElement

    @Delete("server")
    suspend fun stopServer(): JsonElement

    @Get("server/ping")
    suspend fun ping(): JsonElement
}
