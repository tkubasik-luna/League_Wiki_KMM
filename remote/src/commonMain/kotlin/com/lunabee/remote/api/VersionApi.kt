package com.lunabee.remote.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class VersionApi(
    private val httpClient: HttpClient,
) {
    suspend fun getVersions(): List<String> {
        return httpClient.get("api/versions.json").body()
    }
}