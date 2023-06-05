package com.lunabee.leaguewiki.feature.detail

import com.lunabee.domain.model.ChampionDetail
import com.lunabee.domain.model.Passive
import com.lunabee.domain.model.Skin
import com.lunabee.domain.model.Spell
import com.lunabee.leaguewiki.SharedConstants

data class UiChampionDetail(
    val id: String,
    val name: String,
    val imageUrl: String,
    val title: String,
    val lore: String,
    val isFavorite: Boolean,
    val tags: List<String>,
    val skins: List<UiSkin>,
    val passive: UiPassive,
    val spells: List<UiSpell>,
) {
    constructor(championDetail: ChampionDetail) : this(
        id = championDetail.id,
        name = championDetail.name,
        imageUrl = getSplashUrl(championDetail.id, 0),
        title = championDetail.title,
        lore = championDetail.lore,
        isFavorite = championDetail.isFavorite,
        tags = championDetail.tags,
        skins = championDetail.skins.map { UiSkin(it, championDetail.id) },
        passive = UiPassive(championDetail.passive, championDetail.version),
        spells = championDetail.spells.map { UiSpell(it, championDetail.version) },
    )
}

data class UiSkin(
    val name: String,
    val imageUrl: String,
) {
    constructor(
        skin: Skin, champId: String,
    ) : this(
        name = skin.name,
        imageUrl = getSplashUrl(champId, skin.num)
    )
}

data class UiPassive(
    val name: String,
    val description: String,
    val imageUrl: String,
) {
    constructor(passive: Passive, version: String) : this(
        name = passive.name,
        description = passive.description,
        imageUrl = getPassiveUrl(passive.image, version)
    )
}

data class UiSpell(
    val name: String,
    val imageUrl: String,
    val description: String,
) {
    constructor(spell: Spell, version: String) : this(
        name = spell.name,
        description = spell.description,
        imageUrl = getSpellUrl(spell.image, version)
    )
}

private fun getSplashUrl(id: String, num: Int): String {
    return "${SharedConstants.Url.BASE_URL}cdn/img/champion/splash/${id}_${num}.jpg"
}

private fun getPassiveUrl(name: String, version: String): String {
    return "${SharedConstants.Url.BASE_URL}cdn/${version}/img/passive/${name}"
}

private fun getSpellUrl(name: String, version: String): String {
    return "${SharedConstants.Url.BASE_URL}cdn/${version}/img/spell/${name}"
}