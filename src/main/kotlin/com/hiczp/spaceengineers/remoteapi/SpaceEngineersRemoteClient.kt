package com.hiczp.spaceengineers.remoteapi

import com.hiczp.caeruleum.create
import com.hiczp.spaceengineers.remoteapi.service.AdminService
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging
import kotlinx.io.core.Closeable
import org.slf4j.LoggerFactory

class SpaceEngineersRemoteClient : Closeable {
    private val httpClient by lazy {
        HttpClient(CIO) {
            install(Logging) {
                level = if (LoggerFactory.getLogger(SpaceEngineersRemoteClient::class.java).isDebugEnabled) {
                    LogLevel.ALL
                } else {
                    LogLevel.NONE
                }
            }
        }
    }

    val admin = httpClient.create<AdminService>()

    override fun close() {
        httpClient.close()
    }
}
