package com.hiczp.spaceengineers.remoteapi.service.session

data class Message(
    val steamID: Long,
    val displayName: String,
    val content: String,
    val timestamp: Long
)
