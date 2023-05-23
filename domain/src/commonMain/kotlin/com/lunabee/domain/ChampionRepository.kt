package com.lunabee.domain

import com.lunabee.domain.model.ChampionInfo
import kotlinx.coroutines.flow.Flow

interface ChampionRepository {
    fun getTestFlow(): Flow<Int>
    suspend fun getChampionList(): List<ChampionInfo>
}