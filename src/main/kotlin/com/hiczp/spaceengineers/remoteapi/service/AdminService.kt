package com.hiczp.spaceengineers.remoteapi.service

import com.hiczp.caeruleum.annotation.Get
import io.ktor.client.response.HttpResponse

interface AdminService {
    @Get("/v1/admin/bannedPlayers")
    fun getBannedPlayers(): HttpResponse
}
