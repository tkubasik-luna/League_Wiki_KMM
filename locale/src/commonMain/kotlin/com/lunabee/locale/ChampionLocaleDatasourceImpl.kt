package com.lunabee.locale

import com.lunabee.domain.inject.Inject
import com.lunabee.domain.model.ChampionDetail
import com.lunabee.domain.model.ChampionInfo
import com.lunabee.repository.datasource.ChampionLocaleDatasource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map

class ChampionLocaleDatasourceImpl @Inject constructor(
    private val championDao: ChampionDao,
) : ChampionLocaleDatasource {
    override fun getChampionsList(): Flow<List<ChampionInfo>> {
        return combine(
            championDao.getChampionsList(),
            championDao.getFavorites()
        ) { champions, favorites ->
            champions.list.map { champion ->
                val isFavorite = favorites.list.firstOrNull { it.id == champion.id } != null
                champion.toChampionInfo(isFavorite)
            }
        }
    }

    private fun isChampionFavorite(id: String): Flow<Boolean> {
        return championDao.getIsFavorite(id).map { data -> data.list.isNotEmpty() }
    }

    override fun getChampionDetailById(id: String): Flow<ChampionDetail?> {
        return combine(
            championDao.getChampionsDetail(id).map { data -> data.list.firstOrNull() },
            isChampionFavorite(id)
        ) { champion, isFavorite ->
            champion?.toChampionDetail(isFavorite)
        }
    }

    override suspend fun insertChampionDetail(championDetail: ChampionDetail) {
        championDao.insertChampionDetail(championDetail)
    }

    override suspend fun insertChampionsInfo(champions: List<ChampionInfo>) {
        championDao.insertChampionList(champions)
    }

    override suspend fun insertFavorite(id: String, isFavorite: Boolean) {
        if (isFavorite) {
            championDao.insertFavorite(id)
        } else {
            championDao.removeFavorite(id)
        }
    }
}