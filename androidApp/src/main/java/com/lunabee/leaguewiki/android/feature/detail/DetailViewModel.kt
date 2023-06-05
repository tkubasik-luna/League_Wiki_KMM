package com.lunabee.leaguewiki.android.feature.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lunabee.leaguewiki.feature.detail.DetailViewModelDelegate
import com.lunabee.leaguewiki.feature.detail.UiChampionDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

class DetailViewModel(
    private val detailViewModelDelegate: DetailViewModelDelegate,
    handle: SavedStateHandle,
) : ViewModel(), DetailViewModelDelegate by detailViewModelDelegate {
    private val id: String = handle[DetailDestination.ChampionIdArgument]!!

    val championDetail: Flow<UiChampionDetail?> = detailViewModelDelegate.championDetail(id)

    init {
        viewModelScope.launch {
            refresh(id)
        }
    }

    fun uiToggleFavorite() {
        viewModelScope.launch { toggleFavorite(id, !(championDetail.firstOrNull()?.isFavorite ?: false)) }
    }
}