package com.lunabee.leaguewiki.koin

import com.lunabee.leaguewiki.di.commonProvideHttpClient
import com.lunabee.remote.ChampionRemoteDatasourceImpl
import com.lunabee.remote.VersionRemoteDatasourceImpl
import com.lunabee.remote.api.ChampionApi
import com.lunabee.remote.api.VersionApi
import com.lunabee.repository.datasource.ChampionRemoteDatasource
import com.lunabee.repository.datasource.VersionRemoteDatasource
import org.koin.core.module.Module
import org.koin.dsl.module

val remoteModule: Module = module {
    single<ChampionRemoteDatasource> { ChampionRemoteDatasourceImpl(get()) }
    single<VersionRemoteDatasource> { VersionRemoteDatasourceImpl(get()) }
    single { commonProvideHttpClient() }
    single { ChampionApi(get()) }
    single { VersionApi(get()) }
}