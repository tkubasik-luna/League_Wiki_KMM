package com.lunabee.leaguewiki

import com.lunabee.remote.ChampionRemoteDatasourceImpl
import com.lunabee.repository.datasource.ChampionRemoteDatasource
import io.ktor.client.HttpClient
import io.ktor.client.plugins.defaultRequest
import org.koin.core.module.Module
import org.koin.dsl.module

val remoteModule: Module = module {
    single<ChampionRemoteDatasource> { ChampionRemoteDatasourceImpl(get()) }
    single { provideHttpClient() }
}

fun provideHttpClient(): HttpClient {
    return HttpClient {
        defaultRequest {
            url("https://ddragon.leagueoflegends.com")
        }
    }
}