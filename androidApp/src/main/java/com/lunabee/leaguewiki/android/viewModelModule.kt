package com.lunabee.leaguewiki.android

import com.lunabee.leaguewiki.android.feature.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {
    viewModelOf(::HomeViewModel)
}