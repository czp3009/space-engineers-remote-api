package com.hiczp.spaceengineers.remoteapi.service.session

import com.hiczp.caeruleum.annotation.*
import com.hiczp.spaceengineers.remoteapi.service.NoDataResponse
import com.hiczp.spaceengineers.remoteapi.service.Response

interface SessionService {
    @Patch("session")
    suspend fun save(): NoDataResponse

    @Get("session/players")
    suspend fun players(): Response<List<Player>>

    @Get("session/asteroids")
    suspend fun asteroids(): Response<List<Asteroid>>

    @Delete("session/asteroids/{entityId}")
    suspend fun deleteAsteroid(@Path entityId: String): NoDataResponse

    @Get("session/floatingObjects")
    suspend fun floatingObjects(): Response<List<FloatingObject>>

    @Patch("session/floatingObjects/{entityId}")
    suspend fun stopFloatingObject(@Path entityId: String): NoDataResponse

    @Delete("session/floatingObjects/{entityId}")
    suspend fun deleteFloatingObject(@Path entityId: String): NoDataResponse

    @Get("session/grids")
    suspend fun grids(): Response<List<Grid>>

    @Patch("session/grids/{entityId}")
    suspend fun stopGrid(@Path entityId: String): NoDataResponse

    @Delete("session/grids/{entityId}")
    suspend fun deleteGrid(@Path entityId: String): NoDataResponse

    @Post("session/poweredGrids/{entityId}")
    suspend fun powerUpGrid(@Path entityId: String): NoDataResponse

    @Post("session/poweredGrids/{entityId}")
    suspend fun powerDownGrid(@Path entityId: String): NoDataResponse

    @Get("session/planets")
    suspend fun planets(): Response<List<Planet>>

    @Delete("session/planets/{entityId}")
    suspend fun deletePlanet(@Path entityId: String): NoDataResponse

    /**
     * @param timestamp retrieve messages after this time, see C# DateTime.Ticks
     */
    @Get("session/chat")
    suspend fun messages(@Query("Date") timestamp: Long? = null): Response<List<Message>>

    /**
     * @param message must in format ""${message}""
     */
    @Post("session/chat")
    suspend fun sendMessage0(@Body message: String): NoDataResponse

    suspend fun sendMessage(message: String) = sendMessage0(""""$message"""")

    @Get("session/characters")
    suspend fun characters(): Response<List<Character>>

    @Patch("session/characters/{entityId}")
    suspend fun stopCharacter(@Path entityId: String): NoDataResponse
}
