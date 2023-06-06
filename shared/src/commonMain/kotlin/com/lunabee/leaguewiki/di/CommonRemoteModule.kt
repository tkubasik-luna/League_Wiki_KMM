package com.lunabee.leaguewiki.di

import com.lunabee.leaguewiki.RemoteUtils.configureJson
import io.ktor.client.HttpClient
import io.ktor.client.plugins.defaultRequest

fun commonProvideHttpClient(): HttpClient {
    return HttpClient {
        configureJson()
        defaultRequest {
            url("https://ddragon.leagueoflegends.com")
        }
    }
}