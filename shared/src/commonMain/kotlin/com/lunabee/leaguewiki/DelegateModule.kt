package com.lunabee.leaguewiki

import com.lunabee.leaguewiki.feature.home.HomeViewModelDelegate
import com.lunabee.leaguewiki.feature.home.HomeViewModelDelegateImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val delegateModule: Module = module {
    single<HomeViewModelDelegate> { HomeViewModelDelegateImpl(get()) }
}