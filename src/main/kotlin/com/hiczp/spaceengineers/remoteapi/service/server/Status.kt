package com.hiczp.spaceengineers.remoteapi.service.server

data class Status(
    val isReady: Boolean,
    val pirateUsedPCU: Int,
    val players: Int,
    val serverId: Long,
    val serverName: String,
    val simSpeed: Float,
    val simulationCpuLoad: Float,
    val totalTime: Long,
    val usedPCU: Int,
    val version: String,
    val worldName: String
)
