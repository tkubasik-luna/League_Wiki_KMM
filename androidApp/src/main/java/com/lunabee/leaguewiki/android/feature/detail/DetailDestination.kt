package com.lunabee.leaguewiki.android.feature.detail

import com.lunabee.leaguewiki.android.common.LeagueWikiDestination

object DetailDestination : LeagueWikiDestination {
    const val ChampionIdArgument: String = "championId"
    override val route: String = "Detail?$ChampionIdArgument={$ChampionIdArgument}"

    fun getRoute(id: String): String = route.replace("{$ChampionIdArgument}", id.toString())
}