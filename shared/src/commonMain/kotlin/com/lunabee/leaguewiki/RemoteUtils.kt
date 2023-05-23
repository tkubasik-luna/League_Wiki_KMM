package com.lunabee.leaguewiki

import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

internal object RemoteUtils {
    @OptIn(ExperimentalSerializationApi::class)
    internal fun HttpClientConfig<*>.configureJson() {
        // Configure Json serialization.
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true // ignore key not handled.
                    explicitNulls = false // do no set null by default on missing key.
                },
            )
        }
    }
}
