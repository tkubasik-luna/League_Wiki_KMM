package com.lunabee.remote.model

import com.lunabee.domain.model.ChampionDetail
import com.lunabee.domain.model.Info
import com.lunabee.domain.model.Leveltip
import com.lunabee.domain.model.Passive
import com.lunabee.domain.model.Skin
import com.lunabee.domain.model.Spell
import com.lunabee.domain.model.Stats
import kotlinx.serialization.Serializable

@Serializable
data class ApiModelChampionDetail(
    val data: Map<String, ApiChampionDetail>,
    val format: String,
    val type: String,
    val version: String,
) {
    fun getChampionDetail(): ChampionDetail =
        data.toList()[0].second.toChampionDetail(version)
}

@Serializable
data class ApiChampionDetail(
    val allytips: List<String>,
    val blurb: String,
    val enemytips: List<String>,
    val id: String,
    val info: ApiInfo,
    val key: String,
    val lore: String,
    val name: String,
    val partype: String,
    val passive: ApiPassive,
    val skins: List<ApiSkin>,
    val tags: List<String>,
    val title: String,
    val spells: List<ApiSpell>,
    val stats: ApiStats,
) {
    fun toChampionDetail(version: String): ChampionDetail = ChampionDetail(
        allytips,
        blurb,
        enemytips,
        id,
        info.toInfo(),
        key,
        lore,
        name,
        partype,
        passive.toPassive(),
        skins.map { it.toSkin() },
        tags,
        title,
        spells.map { it.toSpell() },
        stats.toStats(),
        version
    )
}

@Serializable
data class ApiInfo(
    val attack: Double,
    val defense: Double,
    val difficulty: Double,
    val magic: Double,
) {
    fun toInfo(): Info = Info(
        this.attack,
        this.defense,
        this.difficulty,
        this.magic
    )
}

@Serializable
data class ApiPassive(
    val description: String,
    val image: ApiImageSpell,
    val name: String,
) {
    fun toPassive(): Passive = Passive(
        this.description,
        this.image.full,
        this.name
    )
}

@Serializable
data class ApiSkin(
    val chromas: Boolean,
    val id: String,
    val name: String,
    val num: Int,
) {
    fun toSkin(): Skin = Skin(
        this.chromas,
        this.id,
        this.name,
        this.num
    )
}

@Serializable
data class ApiSpell(
    val cooldown: List<Double>,
    val cooldownBurn: String,
    val cost: List<Double>,
    val costBurn: String,
    val costType: String,
    val description: String,
    val effect: List<List<Double>?>,
    val id: String,
    val image: ApiImageSpell,
    val leveltip: ApiLeveltip,
    val maxammo: String,
    val maxrank: Int,
    val name: String,
    val range: List<Double>,
    val rangeBurn: String,
    val resource: String,
    val tooltip: String,
    //val vars: List<Any>
) {
    fun toSpell(): Spell = Spell(
        cooldown,
        cooldownBurn,
        cost,
        costBurn,
        costType,
        description,
        effect,
        id,
        image.full,
        leveltip.toLevelTip(),
        maxammo,
        maxrank,
        name,
        range,
        rangeBurn,
        resource,
        tooltip,
    )
}

@Serializable
data class ApiStats(
    val armor: Double?,
    val armorperlevel: Double?,
    val attackdamage: Double?,
    val attackdamageperlevel: Double?,
    val attackrange: Double?,
    val attackspeed: Double?,
    val attackspeedperlevel: Double?,
    val crit: Double?,
    val critperlevel: Double?,
    val hp: Double?,
    val hpperlevel: Double?,
    val hpregen: Double?,
    val hpregenperlevel: Double?,
    val movespeed: Double?,
    val mp: Double?,
    val mpperlevel: Double?,
    val mpregen: Double?,
    val mpregenperlevel: Double?,
    val spellblock: Double?,
    val spellblockperlevel: Double?,
) {
    fun toStats(): Stats = Stats(
        armor,
        armorperlevel,
        attackdamage,
        attackdamageperlevel,
        attackrange,
        attackspeed,
        attackspeedperlevel,
        crit,
        critperlevel,
        hp,
        hpperlevel,
        hpregen,
        hpregenperlevel,
        movespeed,
        mp,
        mpperlevel,
        mpregen,
        mpregenperlevel,
        spellblock,
        spellblockperlevel
    )
}

@Serializable
data class ApiImageSpell(
    val full: String,
    val group: String,
    val sprite: String,
)

@Serializable
data class ApiLeveltip(
    val effect: List<String>,
    val label: List<String>,
) {
    fun toLevelTip(): Leveltip = Leveltip(
        this.effect,
        this.label
    )
}