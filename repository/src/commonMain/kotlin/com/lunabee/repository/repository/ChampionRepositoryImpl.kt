package com.lunabee.repository.repository

import com.lunabee.domain.ChampionRepository
import com.lunabee.domain.model.ChampionInfo
import com.lunabee.repository.datasource.ChampionRemoteDatasource
import com.lunabee.repository.datasource.VersionRemoteDatasource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class ChampionRepositoryImpl(
    private val versionRemoteDatasource: VersionRemoteDatasource,
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

    override suspend fun getChampionList(): List<ChampionInfo> {
        val version = versionRemoteDatasource.fetchLastVersion()
        return championRemoteDatasource.getChampionList(version)
    }
}