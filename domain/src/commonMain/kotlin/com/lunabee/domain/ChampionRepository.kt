package com.lunabee.domain

import com.lunabee.domain.model.Champion
import kotlinx.coroutines.flow.Flow

interface ChampionRepository {
    fun getChampionsInfo(): Flow<List<Champion>>
}