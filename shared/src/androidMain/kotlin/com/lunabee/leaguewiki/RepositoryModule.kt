package com.lunabee.leaguewiki

import com.lunabee.domain.ChampionRepository
import com.lunabee.repository.repository.ChampionRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsChampionRepository(championRepositoryImpl: ChampionRepositoryImpl): ChampionRepository

}