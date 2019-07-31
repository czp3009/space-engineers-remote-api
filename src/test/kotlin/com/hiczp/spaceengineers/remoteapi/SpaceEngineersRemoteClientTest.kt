package com.hiczp.spaceengineers.remoteapi

import com.github.salomonbrys.kotson.fromJson
import com.google.gson.Gson
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
        this.javaClass.getResourceAsStream("/config.json").reader().let {
            Gson().fromJson<Config>(it)
        }.run {
            spaceEngineersRemoteClient = SpaceEngineersRemoteClient(url, key)
        }
    }

    @Test
    fun ping() {
        runBlocking {
            spaceEngineersRemoteClient.server.ping()
        }
    }

    @Test
    fun session() {
        runBlocking {
            with(spaceEngineersRemoteClient.session) {
                save()
                players()
                asteroids()
                floatingObjects()
                grids()
                planets()
                messages()
                sendMessage("Testing 123")
            }
        }
    }

    @Test
    fun server() {
        runBlocking {
            with(spaceEngineersRemoteClient.server) {
                serverStatus()
            }
        }
    }

    @Test
    fun admin() {
        runBlocking {
            with(spaceEngineersRemoteClient.admin) {
                bannedPlayers()
                kickedPlayers()
            }
        }
    }

    @AfterAll
    fun dispose() {
        spaceEngineersRemoteClient.close()
    }
}
