package com.lunabee.remote

import com.lunabee.domain.model.ChampionInfo
import com.lunabee.remote.api.ChampionApi
import com.lunabee.repository.datasource.ChampionRemoteDatasource

class ChampionRemoteDatasourceImpl(
    private val championApi: ChampionApi,
) : ChampionRemoteDatasource {

    override suspend fun getChampionList(version: String): List<ChampionInfo> {
        return championApi.getChampions("fr_FR", version).data.toList().map {
            ChampionInfo(
                it.second.id, it.second.name, it.second.title, it.second.version
            )
        }
    }

}