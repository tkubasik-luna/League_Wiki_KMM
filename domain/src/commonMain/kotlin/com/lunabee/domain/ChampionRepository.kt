package com.lunabee.domain

import com.lunabee.domain.model.ChampionDetail
import com.lunabee.domain.model.ChampionInfo
import kotlinx.coroutines.flow.Flow

interface ChampionRepository {
    fun getChampionsList(): Flow<List<ChampionInfo>>
    suspend fun fetchChampionsList()
    suspend fun fetchChampionsDetail(id: String)
    fun getChampionDetailById(id: String): Flow<ChampionDetail?>
    suspend fun insertFavorite(id: String, isFavorite: Boolean)
}