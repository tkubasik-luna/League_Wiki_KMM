package com.lunabee.leaguewiki.feature.home

import com.lunabee.domain.ChampionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

interface HomeViewModelDelegate {
    val championList: Flow<List<UiChampionInfo>>
    suspend fun refresh()

    suspend fun toggleFavorite(id: String)
}

class HomeViewModelDelegateImpl(
    private val championRepository: ChampionRepository,
) : HomeViewModelDelegate {
    override val championList: Flow<List<UiChampionInfo>> = championRepository.getChampionsList().map { list ->
        list.map { UiChampionInfo.fromChampionInfo(it) }
    }

    override suspend fun refresh() {
        championRepository.fetchChampionsList()
    }

    override suspend fun toggleFavorite(id: String) {
        if (championList.first().first { it.id == id }.isFavorite) {
            championRepository.insertFavorite(id, isFavorite = false)
        } else {
            championRepository.insertFavorite(id, isFavorite = true)
        }
    }
}