package com.hiczp.spaceengineers.remoteapi.service.session

abstract class Entity {
    abstract val displayName: String?
    abstract val entityId: String
    abstract val position: Position
}

data class Position(
    val x: Double,
    val y: Double,
    val z: Double
)

abstract class MovableEntity : Entity() {
    abstract val mass: Float
    abstract val linearSpeed: Int
    abstract val distanceToPlayer: Double
}

data class Grid(
    override val displayName: String?,
    override val entityId: String,
    val gridSize: String,
    val blocksCount: Int,
    override val mass: Float,
    override val position: Position,
    override val linearSpeed: Int,
    override val distanceToPlayer: Double,
    val ownerSteamId: Long,
    val ownerDisplayName: String,
    val isPowered: Boolean,
    val PCU: Int
) : MovableEntity()

data class FloatingObject(
    override val displayName: String?,
    override val entityId: String,
    val kind: String,
    override val mass: Float,
    override val position: Position,
    override val linearSpeed: Int,
    override val distanceToPlayer: Double
) : MovableEntity()

data class Asteroid(
    override val displayName: String?,
    override val entityId: String,
    override val position: Position
) : Entity()

data class Planet(
    override val displayName: String?,
    override val entityId: String,
    override val position: Position
) : Entity()
