package com.lunabee.repository.repository

import com.lunabee.domain.ChampionRepository
import com.lunabee.domain.model.Champion
import com.lunabee.repository.datasource.ChampionRemoteDatasource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class ChampionRepositoryImpl(
    private val championRemoteDatasource: ChampionRemoteDatasource,
) : ChampionRepository {
    override fun getTestFlow(): Flow<Int> {
        val random = Random
        return flow {
            while (true) {
                emit(random.nextInt())
                delay(1000)
            }
        }
    }

    override fun getChampionsInfo(): List<Champion> {
        return championRemoteDatasource.getChampionsInfo()
    }

    override suspend fun getTestDataFromRemote(): String {
        return championRemoteDatasource.getTestDataFromRemote()
    }
}