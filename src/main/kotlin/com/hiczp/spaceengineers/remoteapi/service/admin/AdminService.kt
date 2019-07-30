package com.hiczp.spaceengineers.remoteapi.service.admin

import com.google.gson.JsonElement
import com.hiczp.caeruleum.annotation.Delete
import com.hiczp.caeruleum.annotation.Get
import com.hiczp.caeruleum.annotation.Path
import com.hiczp.caeruleum.annotation.Post

interface AdminService {
//    @Get("admin/promotedPlayers")
//    suspend fun promotedPlayers():JsonElement

    @Post("admin/promotedPlayers/{steamId}")
    suspend fun promotePlayer(@Path steamId: Long): JsonElement

    @Delete("admin/promotedPlayers/{steamId}")
    suspend fun demotePlayer(@Path steamId: Long): JsonElement

    @Get("admin/bannedPlayers")
    suspend fun bannedPlayers(): JsonElement

    @Post("admin/bannedPlayers/{steamId}")
    suspend fun banPlayer(@Path steamId: Long): JsonElement

    @Suppress("SpellCheckingInspection")
    @Delete("admin/bannedPlayers/{steamId}")
    suspend fun unbanPlayer(@Path steamId: Long): JsonElement

    @Get("admin/kickedPlayers")
    suspend fun kickedPlayers(): JsonElement

    @Post("admin/kickedPlayers/{steamId}")
    suspend fun kickPlayer(@Path steamId: Long): JsonElement

    @Suppress("SpellCheckingInspection")
    @Delete("admin/kickedPlayers/{steamId}")
    suspend fun unkickPlayer(@Path steamId: Long): JsonElement
}
