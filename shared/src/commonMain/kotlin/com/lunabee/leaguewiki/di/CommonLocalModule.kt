package com.lunabee.leaguewiki.di

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
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

fun commonProvideRealm(): Realm {
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