package com.hiczp.spaceengineers.remoteapi.service.session

import com.google.gson.JsonElement
import com.hiczp.caeruleum.annotation.*
import com.hiczp.spaceengineers.remoteapi.service.CommonResponse
import com.hiczp.spaceengineers.remoteapi.service.session.model.GetAsteroidsResponse

interface SessionService {
    @Patch("session")
    suspend fun save(): CommonResponse

    @Get("session/players")
    suspend fun players(): JsonElement

    @Get("session/asteroids")
    suspend fun asteroids(): GetAsteroidsResponse

    @Delete("session/asteroids/{entityId}")
    suspend fun deleteAsteroid(@Path entityId: String): JsonElement

    @Get("session/floatingObjects")
    suspend fun floatingObjects(): JsonElement

    @Patch("session/floatingObjects/{entityId}")
    suspend fun stopFloatingObject(@Path entityId: String): JsonElement

    @Delete("session/floatingObjects/{entityId}")
    suspend fun deleteFloatingObject(@Path entityId: String): JsonElement

    @Get("session/grids")
    suspend fun grids(): JsonElement

    @Patch("session/grids/{entityId}")
    suspend fun stopGrid(@Path entityId: String): JsonElement

    @Delete("session/grids/{entityId}")
    suspend fun deleteGrid(@Path entityId: String): JsonElement

    @Post("session/poweredGrids/{entityId}")
    suspend fun powerUpGrid(@Path entityId: String): JsonElement

    @Post("session/poweredGrids/{entityId}")
    suspend fun powerDownGrid(@Path entityId: String): JsonElement

    @Get("session/planets")
    suspend fun planets(): JsonElement

    @Delete("session/planets/{entityId}")
    suspend fun deletePlanet(@Path entityId: String): JsonElement

    @Get("session/chat")
    suspend fun messages(): JsonElement

    @Post("session/chat")
    suspend fun sendMessage(): JsonElement
}
