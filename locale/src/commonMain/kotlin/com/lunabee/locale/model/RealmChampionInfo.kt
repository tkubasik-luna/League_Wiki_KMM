package com.lunabee.locale.model

import com.lunabee.domain.model.ChampionInfo
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class RealmChampionInfo() : RealmObject {
    @PrimaryKey
    var id: String = ""
    var name: String? = null
    var title: String? = null
    var version: String? = null

    constructor(
        id: String = "",
        name: String? = null,
        title: String? = null,
        version: String? = null,
    ) : this() {
        this.id = id
        this.name = name
        this.title = title
        this.version = version
    }

    fun toChampionInfo(isFavorite: Boolean): ChampionInfo {
        return ChampionInfo(
            id, name, title, version, isFavorite
        )
    }

    companion object {
        fun fromChampionInfo(championInfo: ChampionInfo): RealmChampionInfo {
            return RealmChampionInfo(
                championInfo.id,
                championInfo.name,
                championInfo.title,
                championInfo.version,
            )
        }
    }
}