# SpaceEngineers Remote API written in Kotlin
```groovy
api group: 'com.hiczp', name: 'space-engineers-remote-api', version: '0.1.2'
```

# Usage
Http engine is optional, recommend CIO

```groovy
api group: 'io.ktor', name: 'ktor-client-cio', version: ktorVersion
```

See all available engine here https://ktor.io/clients/http-client/engines.html

```kotlin
val spaceEngineersRemoteClient = SpaceEngineersRemoteClient(
    "http://localhost:8080",
    "BbDYO1rQObKCkCyh50Z2UQ==",
    CIO
)
runBlocking {
    spaceEngineersRemoteClient.server.ping().data.run(::println)
    spaceEngineersRemoteClient.session.sendMessage("Testing 123")
}
spaceEngineersRemoteClient.close()
```

# License
Apache 2.0
