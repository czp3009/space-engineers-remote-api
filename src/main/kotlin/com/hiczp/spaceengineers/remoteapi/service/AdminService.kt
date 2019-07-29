package com.hiczp.spaceengineers.remoteapi.service

import com.google.gson.JsonElement
import com.hiczp.caeruleum.annotation.Get

interface AdminService {
    @Get("/v1/admin/bannedPlayers")
    suspend fun getBannedPlayers(): JsonElement
}
