package com.hiczp.spaceengineers.remoteapi.service.session

data class Player(
    val steamID: Long,
    val displayName: String,
    val factionName: String,
    val factionTag: String,
    val promoteLevel: Int,
    val ping: Int
)
