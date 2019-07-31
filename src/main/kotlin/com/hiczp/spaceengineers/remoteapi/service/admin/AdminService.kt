package com.hiczp.spaceengineers.remoteapi.service.admin

import com.google.gson.JsonElement
import com.hiczp.caeruleum.annotation.Delete
import com.hiczp.caeruleum.annotation.Get
import com.hiczp.caeruleum.annotation.Path
import com.hiczp.caeruleum.annotation.Post
import com.hiczp.spaceengineers.remoteapi.service.NoDataResponse
import com.hiczp.spaceengineers.remoteapi.service.Response

interface AdminService {
    @Post("admin/promotedPlayers/{steamId}")
    suspend fun promotePlayer(@Path steamId: Long): NoDataResponse

    @Delete("admin/promotedPlayers/{steamId}")
    suspend fun demotePlayer(@Path steamId: Long): NoDataResponse

    //always empty
    @Get("admin/bannedPlayers")
    suspend fun bannedPlayers(): Response<List<JsonElement>>

    @Post("admin/bannedPlayers/{steamId}")
    suspend fun banPlayer(@Path steamId: Long): NoDataResponse

    @Suppress("SpellCheckingInspection")
    @Delete("admin/bannedPlayers/{steamId}")
    suspend fun unbanPlayer(@Path steamId: Long): NoDataResponse

    //always empty
    @Get("admin/kickedPlayers")
    suspend fun kickedPlayers(): Response<List<JsonElement>>

    @Post("admin/kickedPlayers/{steamId}")
    suspend fun kickPlayer(@Path steamId: Long): NoDataResponse

    @Suppress("SpellCheckingInspection")
    @Delete("admin/kickedPlayers/{steamId}")
    suspend fun unkickPlayer(@Path steamId: Long): NoDataResponse
}
