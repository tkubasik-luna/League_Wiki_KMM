package com.lunabee.locale.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class RealChampionFavorite() : RealmObject {
    @PrimaryKey
    var id: String = ""

    constructor(id: String) : this() {
        this.id = id
    }
}