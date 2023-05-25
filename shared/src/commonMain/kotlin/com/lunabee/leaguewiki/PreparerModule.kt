package com.lunabee.leaguewiki

import com.lunabee.leaguewiki.feature.home.HomeViewModelPreparer
import org.koin.core.module.Module
import org.koin.dsl.module

val preparerModule: Module = module {
    single { HomeViewModelPreparer(get()) }
}