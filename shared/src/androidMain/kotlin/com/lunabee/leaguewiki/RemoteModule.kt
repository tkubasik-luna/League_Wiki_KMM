package com.lunabee.leaguewiki

import com.lunabee.leaguewiki.di.commonProvideHttpClient
import com.lunabee.remote.ChampionRemoteDatasourceImpl
import com.lunabee.remote.VersionRemoteDatasourceImpl
import com.lunabee.repository.datasource.ChampionRemoteDatasource
import com.lunabee.repository.datasource.VersionRemoteDatasource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient

@Module
@InstallIn(SingletonComponent::class)
interface BindsRemoteModule {

    @Binds
    fun bindsChampionRemoteDatasource(championRemoteDatasourceImpl: ChampionRemoteDatasourceImpl): ChampionRemoteDatasource

    @Binds
    fun bindsVersionRemoteDatasource(versionRemoteDatasourceImpl: VersionRemoteDatasourceImpl): VersionRemoteDatasource
}

@Module
@InstallIn(SingletonComponent::class)
object ProvideRemoteModule {

    @Provides
    fun providesHttpClient(): HttpClient {
        return commonProvideHttpClient()
    }
}