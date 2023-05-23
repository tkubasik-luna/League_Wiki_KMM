package com.lunabee.repository.datasource

import com.lunabee.domain.model.ChampionInfo

interface ChampionRemoteDatasource {
    suspend fun getChampionList(version: String): List<ChampionInfo>
}