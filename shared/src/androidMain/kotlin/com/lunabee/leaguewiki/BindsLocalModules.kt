package com.lunabee.leaguewiki

import com.lunabee.leaguewiki.di.commonProvideRealm
import com.lunabee.locale.ChampionLocaleDatasourceImpl
import com.lunabee.repository.datasource.ChampionLocaleDatasource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm

@Module
@InstallIn(SingletonComponent::class)
interface BindsLocalModules {
    @Binds
    fun bindsChampionLocalDatasource(championLocaleDatasourceImpl: ChampionLocaleDatasourceImpl): ChampionLocaleDatasource
}

@Module
@InstallIn(SingletonComponent::class)
object ProvidesLocalModules {
    @Provides
    fun providesRealm(): Realm {
        return commonProvideRealm()
    }
}

