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
    var isFavorite: Boolean = false

    constructor(
        id: String = "",
        name: String? = null,
        title: String? = null,
        version: String? = null,
        isFavorite: Boolean = false,
    ) : this() {
        this.id = id
        this.name = name
        this.title = title
        this.version = version
        this.isFavorite = isFavorite
    }

    fun toChampionInfo(): ChampionInfo {
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
                championInfo.isFavorite
            )
        }
    }
}