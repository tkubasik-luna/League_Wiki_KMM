package com.lunabee.repository

import com.lunabee.domain.ChampionRepository
import com.lunabee.domain.model.Champion
import kotlinx.coroutines.flow.Flow

class ChampionRepositoryImpl : ChampionRepository {

    override fun getChampionsInfo(): Flow<List<Champion>> {
        TODO("Not yet implemented")
    }
}