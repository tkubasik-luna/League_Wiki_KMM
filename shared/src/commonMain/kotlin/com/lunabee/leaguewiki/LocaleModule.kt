package com.lunabee.leaguewiki

import com.lunabee.locale.ChampionDao
import com.lunabee.locale.ChampionLocaleDatasourceImpl
import com.lunabee.locale.model.RealChampionFavorite
import com.lunabee.locale.model.RealmChampionDetail
import com.lunabee.locale.model.RealmChampionInfo
import com.lunabee.locale.model.RealmEffect
import com.lunabee.locale.model.RealmInfo
import com.lunabee.locale.model.RealmLeveltip
import com.lunabee.locale.model.RealmPassive
import com.lunabee.locale.model.RealmSkin
import com.lunabee.locale.model.RealmSpell
import com.lunabee.locale.model.ReamStats
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
    val config = RealmConfiguration.create(
        schema = setOf(
            RealmChampionInfo::class,
            RealmChampionDetail::class,
            RealmInfo::class,
            RealmPassive::class,
            RealmSkin::class,
            RealmSpell::class,
            ReamStats::class,
            RealmEffect::class,
            RealmLeveltip::class,
            RealChampionFavorite::class
        )
    )
    return Realm.open(config)
}