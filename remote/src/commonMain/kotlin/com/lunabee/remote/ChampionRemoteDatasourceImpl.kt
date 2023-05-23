package com.lunabee.remote

import com.lunabee.domain.model.Champion
import com.lunabee.repository.datasource.ChampionRemoteDatasource
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ChampionRemoteDatasourceImpl(
    private val httpClient: HttpClient,
) : ChampionRemoteDatasource {
    override fun getChampionsInfo(): List<Champion> {
        return listOf(
            Champion(
                "1",
                "aatrox",
            ),
            Champion(
                "2",
                "Jhin",
            )
        )
    }

    override suspend fun getTestDataFromRemote(): String {
        return httpClient.get("cdn/13.10.1/data/fr_FR/champion.json").body()
    }
}