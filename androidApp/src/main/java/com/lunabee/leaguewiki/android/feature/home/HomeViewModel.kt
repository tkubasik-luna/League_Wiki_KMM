package com.lunabee.leaguewiki.android.feature.home

import androidx.lifecycle.ViewModel
import com.lunabee.leaguewiki.feature.home.HomeViewModelPreparer
import com.lunabee.leaguewiki.feature.home.UiChampionInfo
import kotlinx.coroutines.flow.Flow

class HomeViewModel(
    private val homeViewModelPreparer: HomeViewModelPreparer,
) : ViewModel() {
    val championsList: Flow<List<UiChampionInfo>> = homeViewModelPreparer.championList
}