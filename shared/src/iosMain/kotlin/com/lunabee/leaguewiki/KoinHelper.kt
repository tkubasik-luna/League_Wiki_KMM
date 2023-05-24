package com.lunabee.leaguewiki

import com.lunabee.domain.ChampionRepository
import com.lunabee.domain.model.ChampionInfo
import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

class IosChampionRepository : KoinComponent {
    private val championRepository: ChampionRepository by inject()

    @NativeCoroutines
    suspend fun getChampionList() {
        championRepository.fetchChampionsList()
    }

    @NativeCoroutines
    val championListFlow: Flow<List<ChampionInfo>> = championRepository.getChampionsList()
}

fun initKoin() {
    startKoin {
        modules(logicModule())
    }
}