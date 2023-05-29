package com.lunabee.leaguewiki

import org.koin.core.module.Module

fun logicModule(): List<Module> = listOf(domainModule, remoteModule, localeModule, delegateModule)