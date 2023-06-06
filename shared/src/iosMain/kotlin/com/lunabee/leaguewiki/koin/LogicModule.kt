package com.lunabee.leaguewiki.koin

import org.koin.core.module.Module

fun logicModule(): List<Module> = listOf(domainModule, remoteModule, localeModule, delegateModule)