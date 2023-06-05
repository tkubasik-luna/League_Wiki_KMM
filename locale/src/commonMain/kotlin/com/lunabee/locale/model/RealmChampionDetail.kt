package com.lunabee.locale.model

import com.lunabee.domain.model.ChampionDetail
import com.lunabee.domain.model.Info
import com.lunabee.domain.model.Leveltip
import com.lunabee.domain.model.Passive
import com.lunabee.domain.model.Skin
import com.lunabee.domain.model.Spell
import com.lunabee.domain.model.Stats
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.ext.toRealmList
import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class RealmChampionDetail() : RealmObject {
    @PrimaryKey
    var id: String = ""
    var allytips: RealmList<String> = realmListOf()
    var blurb: String = ""
    var enemytips: RealmList<String> = realmListOf()
    var info: RealmInfo? = null
    var key: String = ""
    var lore: String = ""
    var name: String = ""
    var partype: String = ""
    var passive: RealmPassive? = null
    var skins: RealmList<RealmSkin> = realmListOf()
    var tags: RealmList<String> = realmListOf()
    var title: String = ""
    var spells: RealmList<RealmSpell> = realmListOf()
    var stats: ReamStats? = null
    var version: String = ""

    constructor(
        id: String,
        allytips: RealmList<String>,
        blurb: String,
        enemytips: RealmList<String>,
        info: RealmInfo?,
        key: String,
        lore: String,
        name: String,
        partype: String,
        passive: RealmPassive?,
        skins: RealmList<RealmSkin>,
        tags: RealmList<String>,
        title: String,
        spells: RealmList<RealmSpell>,
        stats: ReamStats?,
        version: String,
    ) : this() {
        this.id = id
        this.allytips = allytips
        this.blurb = blurb
        this.enemytips = enemytips
        this.info = info
        this.key = key
        this.lore = lore
        this.name = name
        this.partype = partype
        this.passive = passive
        this.skins = skins
        this.tags = tags
        this.title = title
        this.spells = spells
        this.stats = stats
        this.version = version
    }

    fun toChampionDetail(isFavorite: Boolean): ChampionDetail {
        return ChampionDetail(
            id = id,
            allytips = allytips.toList(),
            blurb = blurb,
            enemytips = enemytips.toList(),
            info = info!!.toInfo(),
            key = key,
            lore = lore,
            name = name,
            partype = partype,
            passive = passive!!.toPassive(),
            skins = skins.toList().map { it.toSkin() },
            tags = tags.toList(),
            title = title,
            spells = spells.toList().map { it.toSpell() },
            stats = stats!!.toStats(),
            version = version,
            isFavorite = isFavorite
        )
    }

    companion object {
        fun fromChampionDetail(championDetail: ChampionDetail): RealmChampionDetail {
            return RealmChampionDetail(
                id = championDetail.id,
                allytips = championDetail.allytips.toRealmList(),
                blurb = championDetail.blurb,
                enemytips = championDetail.enemytips.toRealmList(),
                info = RealmInfo.fromInfo(championDetail.info),
                key = championDetail.key,
                lore = championDetail.lore,
                name = championDetail.name,
                partype = championDetail.partype,
                passive = RealmPassive.fromPassive(championDetail.passive),
                skins = championDetail.skins.map { RealmSkin.fromSkin(it) }.toRealmList(),
                tags = championDetail.tags.toRealmList(),
                title = championDetail.title,
                spells = championDetail.spells.map { RealmSpell.fromSpell(it) }.toRealmList(),
                stats = ReamStats.fromStat(championDetail.stats),
                version = championDetail.version,
            )
        }
    }
}

class RealmInfo() : EmbeddedRealmObject {

    var attack: Double = 0.0
    var defense: Double = 0.0
    var difficulty: Double = 0.0
    var magic: Double = 0.0

    constructor(attack: Double, defense: Double, difficulty: Double, magic: Double) : this() {
        this.attack = attack
        this.defense = defense
        this.difficulty = difficulty
        this.magic = magic
    }

    fun toInfo(): Info {
        return Info(
            attack = attack,
            defense = defense,
            difficulty = difficulty,
            magic = magic,
        )
    }

    companion object {
        fun fromInfo(info: Info): RealmInfo {
            return RealmInfo(
                attack = info.attack,
                defense = info.defense,
                difficulty = info.difficulty,
                magic = info.magic,
            )
        }
    }
}

class RealmPassive() : EmbeddedRealmObject {
    var description: String = ""
    var image: String = ""
    var name: String = ""

    constructor(description: String, image: String, name: String) : this() {
        this.description = description
        this.image = image
        this.name = name
    }

    fun toPassive(): Passive {
        return Passive(
            description = description,
            image = image,
            name = name,
        )
    }

    companion object {
        fun fromPassive(passive: Passive): RealmPassive {
            return RealmPassive(
                description = passive.description,
                image = passive.image,
                name = passive.name
            )
        }
    }
}

class RealmSkin() : EmbeddedRealmObject {
    var chromas: Boolean = false
    var id: String = ""
    var name: String = ""
    var num: Int = 0

    constructor(chromas: Boolean, id: String, name: String, num: Int) : this() {
        this.chromas = chromas
        this.id = id
        this.name = name
        this.num = num
    }

    fun toSkin(): Skin {
        return Skin(
            chromas = chromas,
            id = id,
            name = name,
            num = num,
        )
    }

    companion object {
        fun fromSkin(skin: Skin): RealmSkin {
            return RealmSkin(
                chromas = skin.chromas,
                id = skin.id,
                name = skin.name,
                num = skin.num,
            )
        }
    }
}

class RealmSpell() : EmbeddedRealmObject {
    var cooldown: RealmList<Double> = realmListOf()
    var cooldownBurn: String = ""
    var cost: RealmList<Double> = realmListOf()
    var costBurn: String = ""
    var costType: String = ""
    var description: String = ""
    var effect: RealmList<RealmEffect> = realmListOf()
    var id: String = ""
    var image: String = ""
    var leveltip: RealmLeveltip? = null
    var maxammo: String = ""
    var maxrank: Int = 0
    var name: String = ""
    var range: RealmList<Double> = realmListOf()
    var rangeBurn: String = ""
    var resource: String = ""
    var tooltip: String = " "

    constructor(
        cooldown: RealmList<Double>,
        cooldownBurn: String,
        cost: RealmList<Double>,
        costBurn: String,
        costType: String,
        description: String,
        effect: RealmList<RealmEffect>,
        id: String,
        image: String,
        leveltip: RealmLeveltip?,
        maxammo: String,
        maxrank: Int,
        name: String,
        range: RealmList<Double>,
        rangeBurn: String,
        resource: String,
        tooltip: String,
    ) : this() {
        this.cooldown = cooldown
        this.cooldownBurn = cooldownBurn
        this.cost = cost
        this.costBurn = costBurn
        this.costType = costType
        this.description = description
        this.effect = effect
        this.id = id
        this.image = image
        this.leveltip = leveltip
        this.maxammo = maxammo
        this.maxrank = maxrank
        this.name = name
        this.range = range
        this.rangeBurn = rangeBurn
        this.resource = resource
        this.tooltip = tooltip
    }

    fun toSpell(): Spell {
        return Spell(
            cooldown = cooldown.toList(),
            cooldownBurn = cooldownBurn,
            cost = cost.toList(),
            costBurn = costBurn,
            costType = costType,
            description = description,
            effect = effect.toList().map { it.list.toList() },
            id = id,
            image = image,
            leveltip = leveltip!!.toLevelTip(),
            maxammo = maxammo,
            maxrank = maxrank,
            name = name,
            range = range.toList(),
            rangeBurn = rangeBurn,
            resource = resource,
            tooltip = tooltip,
        )
    }

    companion object {
        fun fromSpell(spell: Spell): RealmSpell {
            return RealmSpell(
                cooldown = spell.cooldown.toRealmList(),
                cooldownBurn = spell.cooldownBurn,
                cost = spell.cost.toRealmList(),
                costBurn = spell.costBurn,
                costType = spell.costType,
                description = spell.description,
                effect = spell.effect.map { RealmEffect((it ?: listOf()).toRealmList()) }.toRealmList(),
                id = spell.id,
                image = spell.image,
                leveltip = RealmLeveltip.fromLevelTip(spell.leveltip),
                maxammo = spell.maxammo,
                maxrank = spell.maxrank,
                name = spell.name,
                range = spell.range.toRealmList(),
                rangeBurn = spell.rangeBurn,
                resource = spell.resource,
                tooltip = spell.tooltip
            )
        }
    }
}

class RealmEffect() : EmbeddedRealmObject {
    var list: RealmList<Double> = realmListOf()

    constructor(list: RealmList<Double>) : this() {
        this.list = list
    }
}

class ReamStats() : EmbeddedRealmObject {
    var armor: Double? = null
    var armorperlevel: Double? = null
    var attackdamage: Double? = null
    var attackdamageperlevel: Double? = null
    var attackrange: Double? = null
    var attackspeed: Double? = null
    var attackspeedperlevel: Double? = null
    var crit: Double? = null
    var critperlevel: Double? = null
    var hp: Double? = null
    var hpperlevel: Double? = null
    var hpregen: Double? = null
    var hpregenperlevel: Double? = null
    var movespeed: Double? = null
    var mp: Double? = null
    var mpperlevel: Double? = null
    var mpregen: Double? = null
    var mpregenperlevel: Double? = null
    var spellblock: Double? = null
    var spellblockperlevel: Double? = null

    constructor(
        armor: Double?,
        armorperlevel: Double?,
        attackdamage: Double?,
        attackdamageperlevel: Double?,
        attackrange: Double?,
        attackspeed: Double?,
        attackspeedperlevel: Double?,
        crit: Double?,
        critperlevel: Double?,
        hp: Double?,
        hpperlevel: Double?,
        hpregen: Double?,
        hpregenperlevel: Double?,
        movespeed: Double?,
        mp: Double?,
        mpperlevel: Double?,
        mpregen: Double?,
        mpregenperlevel: Double?,
        spellblock: Double?,
        spellblockperlevel: Double?,
    ) : this() {
        this.armor = armor
        this.armorperlevel = armorperlevel
        this.attackdamage = attackdamage
        this.attackdamageperlevel = attackdamageperlevel
        this.attackrange = attackrange
        this.attackspeed = attackspeed
        this.attackspeedperlevel = attackspeedperlevel
        this.crit = crit
        this.critperlevel = critperlevel
        this.hp = hp
        this.hpperlevel = hpperlevel
        this.hpregen = hpregen
        this.hpregenperlevel = hpregenperlevel
        this.movespeed = movespeed
        this.mp = mp
        this.mpperlevel = mpperlevel
        this.mpregen = mpregen
        this.mpregenperlevel = mpregenperlevel
        this.spellblock = spellblock
        this.spellblockperlevel = spellblockperlevel
    }

    fun toStats(): Stats {
        return Stats(
            armor = armor,
            armorperlevel = armorperlevel,
            attackdamage = attackdamage,
            attackdamageperlevel = attackdamageperlevel,
            attackrange = attackrange,
            attackspeed = attackspeed,
            attackspeedperlevel = attackspeedperlevel,
            crit = crit,
            critperlevel = critperlevel,
            hp = hp,
            hpperlevel = hpperlevel,
            hpregen = hpregen,
            hpregenperlevel = hpregenperlevel,
            movespeed = movespeed,
            mp = mp,
            mpperlevel = mpperlevel,
            mpregen = mpregen,
            mpregenperlevel = mpregenperlevel,
            spellblock = spellblock,
            spellblockperlevel = spellblockperlevel
        )
    }

    companion object {
        fun fromStat(stats: Stats): ReamStats {
            return ReamStats(
                armor = stats.armor,
                armorperlevel = stats.armorperlevel,
                attackdamage = stats.attackdamage,
                attackdamageperlevel = stats.attackdamageperlevel,
                attackrange = stats.attackrange,
                attackspeed = stats.attackspeed,
                attackspeedperlevel = stats.attackspeedperlevel,
                crit = stats.crit,
                critperlevel = stats.critperlevel,
                hp = stats.hp,
                hpperlevel = stats.hpperlevel,
                hpregen = stats.hpregen,
                hpregenperlevel = stats.hpregenperlevel,
                movespeed = stats.movespeed,
                mp = stats.mp,
                mpperlevel = stats.mpperlevel,
                mpregen = stats.mpregen,
                mpregenperlevel = stats.mpregenperlevel,
                spellblock = stats.spellblock,
                spellblockperlevel = stats.spellblockperlevel
            )
        }
    }
}

class RealmLeveltip() : EmbeddedRealmObject {
    var effect: RealmList<String> = realmListOf()
    var label: RealmList<String> = realmListOf()

    constructor(effect: RealmList<String>, label: RealmList<String>) : this() {
        this.effect = effect
        this.label = label
    }

    fun toLevelTip(): Leveltip {
        return Leveltip(
            effect = this.effect.toList(),
            label = this.label.toList(),
        )
    }

    companion object {
        fun fromLevelTip(leveltip: Leveltip): RealmLeveltip {
            return RealmLeveltip(
                effect = leveltip.effect.toRealmList(),
                label = leveltip.label.toRealmList()
            )
        }
    }
}