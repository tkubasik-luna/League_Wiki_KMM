package com.lunabee.leaguewiki.android.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lunabee.leaguewiki.feature.home.HomeViewModelPreparer
import com.lunabee.leaguewiki.feature.home.UiChampionInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val homeViewModelPreparer: HomeViewModelPreparer,
) : ViewModel() {
    val championsList: Flow<List<UiChampionInfo>> = homeViewModelPreparer.championList

    init {
        viewModelScope.launch {
            homeViewModelPreparer.refresh()
        }
    }
}