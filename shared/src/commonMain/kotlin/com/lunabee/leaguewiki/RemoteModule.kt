package com.lunabee.leaguewiki

import com.lunabee.leaguewiki.RemoteUtils.configureJson
import com.lunabee.remote.ChampionRemoteDatasourceImpl
import com.lunabee.remote.VersionRemoteDatasourceImpl
import com.lunabee.remote.api.ChampionApi
import com.lunabee.remote.api.VersionApi
import com.lunabee.repository.datasource.ChampionRemoteDatasource
import com.lunabee.repository.datasource.VersionRemoteDatasource
import io.ktor.client.HttpClient
import io.ktor.client.plugins.defaultRequest
import org.koin.core.module.Module
import org.koin.dsl.module

val remoteModule: Module = module {
    single<ChampionRemoteDatasource> { ChampionRemoteDatasourceImpl(get()) }
    single<VersionRemoteDatasource> { VersionRemoteDatasourceImpl(get()) }
    single { provideHttpClient() }
    single { ChampionApi(get()) }
    single { VersionApi(get()) }
}

fun provideHttpClient(): HttpClient {
    return HttpClient {
        configureJson()
        defaultRequest {
            url("https://ddragon.leagueoflegends.com")
        }
    }
}