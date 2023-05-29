package com.lunabee.leaguewiki.home

import com.lunabee.leaguewiki.feature.home.HomeViewModelDelegate
import com.lunabee.leaguewiki.feature.home.UiChampionInfo
import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class IosHomeViewModelDelegate : KoinComponent {
    private val instance: HomeViewModelDelegate by inject()

    @NativeCoroutines
    val championList: Flow<List<UiChampionInfo>> = instance.championList

    @NativeCoroutines
    suspend fun refresh() {
        instance.refresh()
    }

    @NativeCoroutines
    suspend fun toggleFavorite(id: String) {
        instance.toggleFavorite(id)
    }
}