# SpaceEngineers Remote API written in Kotlin
developing

# Usage
```kotlin
val spaceEngineersRemoteClient = SpaceEngineersRemoteClient(
    "http://localhost:8080",
    "0123456789"
)
runBlocking {
    spaceEngineersRemoteClient.server.ping().data.run(::println)
    spaceEngineersRemoteClient.session.sendMessage("Testing 123")
}
spaceEngineersRemoteClient.close()
```
