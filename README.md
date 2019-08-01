# SpaceEngineers Remote API written in Kotlin
```gradle
api group: 'com.hiczp', name: 'space-engineers-remote-api', version: '0.1'
```

# Usage
```kotlin
val spaceEngineersRemoteClient = SpaceEngineersRemoteClient(
    "http://localhost:8080",
    "BbDYO1rQObKCkCyh50Z2UQ=="
)
runBlocking {
    spaceEngineersRemoteClient.server.ping().data.run(::println)
    spaceEngineersRemoteClient.session.sendMessage("Testing 123")
}
spaceEngineersRemoteClient.close()
```

# License
Apache 2.0
