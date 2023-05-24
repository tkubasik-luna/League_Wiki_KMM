package com.lunabee.repository.repository

import com.lunabee.domain.ChampionRepository
import com.lunabee.domain.model.ChampionDetail
import com.lunabee.domain.model.ChampionInfo
import com.lunabee.repository.datasource.ChampionLocaleDatasource
import com.lunabee.repository.datasource.ChampionRemoteDatasource
import com.lunabee.repository.datasource.VersionRemoteDatasource
import kotlinx.coroutines.flow.Flow

class ChampionRepositoryImpl(
    private val versionRemoteDatasource: VersionRemoteDatasource,
    private val championRemoteDatasource: ChampionRemoteDatasource,
    private val championLocaleDatasource: ChampionLocaleDatasource,
) : ChampionRepository {
    override fun getChampionsList(): Flow<List<ChampionInfo>> {
        return championLocaleDatasource.getChampionsList()
    }

    override suspend fun fetchChampionsList() {
        val version = versionRemoteDatasource.fetchLastVersion()
        val result = championRemoteDatasource.getChampionList(version)
        championLocaleDatasource.insertChampionsInfo(result)
    }

    override suspend fun fetchChampionsDetail(id: String) {
        val version = versionRemoteDatasource.fetchLastVersion()
        val result = championRemoteDatasource.getChampionDetail(version = version, id = id)
        championLocaleDatasource.insertChampionDetail(result)
    }

    override fun getChampionDetailById(id: String): Flow<ChampionDetail?> {
        return championLocaleDatasource.getChampionDetailById(id)
    }

    override suspend fun insertFavorite(id: String, isFavorite: Boolean) {
        championLocaleDatasource.insertFavorite(id, isFavorite)
    }
}