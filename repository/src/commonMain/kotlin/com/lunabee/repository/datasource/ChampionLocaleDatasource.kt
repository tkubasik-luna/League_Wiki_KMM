package com.lunabee.repository.datasource

import com.lunabee.domain.model.ChampionDetail
import com.lunabee.domain.model.ChampionInfo
import kotlinx.coroutines.flow.Flow

interface ChampionLocaleDatasource {
    fun getChampionsList(): Flow<List<ChampionInfo>>
    fun getChampionDetailById(id: String): Flow<ChampionDetail?>
    suspend fun insertChampionDetail(championDetail: ChampionDetail)
    suspend fun insertChampionsInfo(champions: List<ChampionInfo>)
    suspend fun insertFavorite(id: String, isFavorite: Boolean)
}