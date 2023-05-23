package com.lunabee.leaguewiki

import com.lunabee.domain.ChampionRepository
import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

class IosChampionRepository : KoinComponent {
    val championRepository: ChampionRepository by inject()

    @NativeCoroutines
    val testFlow: Flow<Int> = championRepository.getTestFlow()

    @NativeCoroutines
    suspend fun getRandomTestData(): String = championRepository.getTestDataFromRemote()
}

fun initKoin() {
    startKoin {
        modules(logicModule())
    }
}