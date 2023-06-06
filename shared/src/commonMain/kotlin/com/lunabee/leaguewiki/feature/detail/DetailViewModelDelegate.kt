package com.lunabee.leaguewiki.feature.detail

import com.lunabee.domain.ChampionRepository
import com.lunabee.domain.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface DetailViewModelDelegate {
    fun championDetail(id: String): Flow<UiChampionDetail?>

    suspend fun refresh(id: String)

    suspend fun toggleFavorite(id: String, isFavorite: Boolean)
}

class DetailViewModelDelegateImpl @Inject constructor(
    private val championRepository: ChampionRepository,
) : DetailViewModelDelegate {
    override fun championDetail(id: String): Flow<UiChampionDetail?> {
        return championRepository.getChampionDetailById(id).map { it?.let { UiChampionDetail(it) } }
    }

    override suspend fun refresh(id: String) {
        championRepository.fetchChampionsDetail(id)
    }

    override suspend fun toggleFavorite(id: String, isFavorite: Boolean) {
        championRepository.insertFavorite(id, isFavorite)
    }
}