package com.lunabee.repository.datasource

import com.lunabee.domain.model.Champion
import kotlinx.coroutines.flow.Flow

interface ChampionRemoteDatasource {
    fun getChampionsInfo(): List<Champion>
}