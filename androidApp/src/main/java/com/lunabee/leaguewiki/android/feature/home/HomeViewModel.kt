package com.lunabee.leaguewiki.android.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lunabee.leaguewiki.feature.home.HomeViewModelDelegate
import com.lunabee.leaguewiki.feature.home.HomeViewModelDelegateImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeViewModelDelegate: HomeViewModelDelegateImpl,
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