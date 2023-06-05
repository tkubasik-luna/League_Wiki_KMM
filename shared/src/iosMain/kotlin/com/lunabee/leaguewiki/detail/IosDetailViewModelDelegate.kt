package com.lunabee.leaguewiki.detail

import com.lunabee.leaguewiki.feature.detail.DetailViewModelDelegate
import com.lunabee.leaguewiki.feature.detail.UiChampionDetail
import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class IosDetailViewModelDelegate : KoinComponent {
    private val instance: DetailViewModelDelegate by inject()

    @NativeCoroutines
    fun championDetail(id: String): Flow<UiChampionDetail?> = instance.championDetail(id)

    @NativeCoroutines
    suspend fun refresh(id: String) = instance.refresh(id)

    @NativeCoroutines
    suspend fun toggleFavorite(id: String, isFavorite: Boolean) = instance.toggleFavorite(id, isFavorite)

}