package com.lunabee.locale

import com.lunabee.domain.model.ChampionDetail
import com.lunabee.domain.model.ChampionInfo
import com.lunabee.repository.datasource.ChampionLocaleDatasource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ChampionLocaleDatasourceImpl(
    private val championDao: ChampionDao,
) : ChampionLocaleDatasource {
    override fun getChampionsList(): Flow<List<ChampionInfo>> {
        return championDao.getChampionsList().map { data ->
            data.list.map {
                it.toChampionInfo()
            }
        }
    }

    override fun getChampionDetailById(id: String): Flow<ChampionDetail?> {
        TODO("Not yet implemented")
    }

    override suspend fun insertChampionDetail(championDetail: ChampionDetail) {
        TODO("Not yet implemented")
    }

    override suspend fun insertChampionsInfo(champions: List<ChampionInfo>) {
        championDao.insertChampionList(champions)
    }

    override suspend fun insertFavorite(id: String, isFavorite: Boolean) {
        championDao.insertFavorite(id, isFavorite)
    }
}