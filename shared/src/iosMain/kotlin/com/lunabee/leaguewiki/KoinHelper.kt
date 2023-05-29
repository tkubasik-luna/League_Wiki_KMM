package com.lunabee.leaguewiki

import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(logicModule())
    }
}