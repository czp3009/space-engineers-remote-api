package com.hiczp.spaceengineers.remoteapi

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SpaceEngineersRemoteClientTest {
    private lateinit var spaceEngineersRemoteClient: SpaceEngineersRemoteClient

    @BeforeAll
    fun init() {
        spaceEngineersRemoteClient = SpaceEngineersRemoteClient("http://localhost:8080")
    }

    @Test
    fun getAdmin() {
        runBlocking {
            spaceEngineersRemoteClient.admin.getBannedPlayers()
        }
    }

    @AfterAll
    fun dispose() {
        spaceEngineersRemoteClient.close()
    }
}
