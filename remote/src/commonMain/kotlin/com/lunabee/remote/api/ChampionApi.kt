package com.lunabee.remote.api

import com.lunabee.domain.inject.Inject
import com.lunabee.remote.model.ApiModelChampionDetail
import com.lunabee.remote.model.ApiModelChampionList
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ChampionApi @Inject constructor(
    private val httpClient: HttpClient,
) {
    suspend fun getChampions(
        language: String,
        version: String = "12.3.1",
    ): ApiModelChampionList {
        return httpClient.get("cdn/$version/data/$language/champion.json").body()
    }

    suspend fun getDetailChamp(
        language: String,
        champId: String,
        version: String = "12.3.1",
    ): ApiModelChampionDetail {
        return httpClient.get("cdn/$version/data/$language/champion/$champId.json").body()
    }
}