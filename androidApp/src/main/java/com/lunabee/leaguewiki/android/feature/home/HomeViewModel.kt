package com.lunabee.leaguewiki.android.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lunabee.leaguewiki.feature.home.HomeViewModelDelegate
import kotlinx.coroutines.launch

class HomeViewModel(
    private val homeViewModelDelegate: HomeViewModelDelegate,
) : ViewModel(), HomeViewModelDelegate by homeViewModelDelegate {
    init {
        viewModelScope.launch {
            refresh()
        }
    }

    fun uiToggleFavorite(id: String) {
        viewModelScope.launch { toggleFavorite(id) }
    }
}