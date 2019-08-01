package com.hiczp.spaceengineers.remoteapi.service.session

abstract class Entity {
    abstract val displayName: String?
    abstract val entityId: Long
    abstract val position: Position
}

data class Position(
    val x: Double,
    val y: Double,
    val z: Double
)

abstract class MovableEntity : Entity() {
    abstract val mass: Float
    abstract val linearSpeed: Float
}

abstract class NonPlayerMovableEntity : MovableEntity() {
    abstract val distanceToPlayer: Double
}

data class Grid(
    override val displayName: String?,
    override val entityId: Long,
    val gridSize: String,
    val blocksCount: Int,
    override val mass: Float,
    override val position: Position,
    override val linearSpeed: Float,
    override val distanceToPlayer: Double,
    val ownerSteamId: Long,
    val ownerDisplayName: String,
    val isPowered: Boolean,
    val PCU: Int
) : NonPlayerMovableEntity()

data class FloatingObject(
    override val displayName: String?,
    override val entityId: Long,
    val kind: String,
    override val mass: Float,
    override val position: Position,
    override val linearSpeed: Float,
    override val distanceToPlayer: Double
) : NonPlayerMovableEntity()

data class Asteroid(
    override val displayName: String?,
    override val entityId: Long,
    override val position: Position
) : Entity()

data class Planet(
    override val displayName: String?,
    override val entityId: Long,
    override val position: Position
) : Entity()

data class Character(
    override val displayName: String?,
    override val entityId: Long,
    override val mass: Float,
    override val position: Position,
    override val linearSpeed: Float
) : MovableEntity()
