package com.lunabee.domain

import com.lunabee.domain.model.Champion
import kotlinx.coroutines.flow.Flow

interface ChampionRepository {
    fun getTestFlow(): Flow<Int>
    fun getChampionsInfo(): List<Champion>
    suspend fun getTestDataFromRemote(): String
}