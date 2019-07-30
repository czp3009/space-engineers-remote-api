package com.hiczp.spaceengineers.remoteapi

import com.google.gson.FieldNamingPolicy
import com.hiczp.caeruleum.create
import com.hiczp.spaceengineers.remoteapi.service.admin.AdminService
import com.hiczp.spaceengineers.remoteapi.service.server.ServerService
import com.hiczp.spaceengineers.remoteapi.service.session.SessionService
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.Url
import io.ktor.http.fullPath
import io.ktor.http.toHttpDateString
import io.ktor.util.KtorExperimentalAPI
import kotlinx.io.core.Closeable
import org.slf4j.LoggerFactory
import java.time.Instant
import java.util.*
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import kotlin.random.Random
import kotlin.random.nextInt

/**
 * @param url http address. For example "http://localhost:8080"
 * @param key base64 encoded secret key
 */
class SpaceEngineersRemoteClient(url: String, key: String) : Closeable {
    private val baseUrl = "$url/vrageremote/v1/"
    private val secretKey = SecretKeySpec(Base64.getDecoder().decode(key), "HmacSHA1")

    @UseExperimental(KtorExperimentalAPI::class)
    private val httpClient = HttpClient(CIO) {
        install(Logging) {
            level = if (LoggerFactory.getLogger(SpaceEngineersRemoteClient::class.java).isDebugEnabled) {
                LogLevel.ALL
            } else {
                LogLevel.NONE
            }
        }
        defaultRequest {
            val nonce = Random.nextInt(0..Int.MAX_VALUE)
            val date = Instant.now().toHttpDateString()
            val message = "${Url(this.url).fullPath}\r\n$nonce\r\n$date\r\n"
            val hash = Mac.getInstance("HmacSHA1").apply {
                init(secretKey)
            }.doFinal(message.toByteArray()).let {
                Base64.getEncoder().encodeToString(it)
            }
            header("Date", date)
            header("Authorization", "$nonce:$hash")
        }
        install(JsonFeature) {
            serializer = GsonSerializer {
                setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            }
        }
    }

    val session by lazy { httpClient.create<SessionService>(baseUrl) }
    val server by lazy { httpClient.create<ServerService>(baseUrl) }
    val admin by lazy { httpClient.create<AdminService>(baseUrl) }

    override fun close() {
        httpClient.close()
    }
}
