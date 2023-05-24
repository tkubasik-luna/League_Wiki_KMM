package com.lunabee.leaguewiki

import com.lunabee.locale.ChampionDao
import com.lunabee.locale.ChampionLocaleDatasourceImpl
import com.lunabee.locale.model.RealmChampionInfo
import com.lunabee.repository.datasource.ChampionLocaleDatasource
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import org.koin.core.module.Module
import org.koin.dsl.module

val localeModule: Module = module {
    single { provideRealm() }
    single { ChampionDao(get()) }
    single<ChampionLocaleDatasource> { ChampionLocaleDatasourceImpl(get()) }
}

fun provideRealm(): Realm {
    val config = RealmConfiguration.create(schema = setOf(RealmChampionInfo::class))
    return Realm.open(config)
}