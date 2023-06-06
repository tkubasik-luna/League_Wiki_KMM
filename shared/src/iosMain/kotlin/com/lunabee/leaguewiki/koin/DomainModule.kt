package com.lunabee.leaguewiki.koin

import com.lunabee.domain.ChampionRepository
import com.lunabee.repository.repository.ChampionRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val domainModule: Module = module {
    single<ChampionRepository> { ChampionRepositoryImpl(get(), get(), get()) }
}