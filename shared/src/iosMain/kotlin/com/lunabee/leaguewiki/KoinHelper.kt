package com.lunabee.leaguewiki

import com.lunabee.leaguewiki.koin.logicModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(logicModule())
    }
}