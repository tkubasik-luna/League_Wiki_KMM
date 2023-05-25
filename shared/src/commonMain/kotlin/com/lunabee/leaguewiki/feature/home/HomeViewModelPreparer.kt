package com.lunabee.leaguewiki.feature.home

import com.lunabee.domain.ChampionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HomeViewModelPreparer(
    championRepository: ChampionRepository,
) {
    val championList: Flow<List<UiChampionInfo>> = championRepository.getChampionsList().map { list ->
        list.map { UiChampionInfo.fromChampionInfo(it) }
    }
}