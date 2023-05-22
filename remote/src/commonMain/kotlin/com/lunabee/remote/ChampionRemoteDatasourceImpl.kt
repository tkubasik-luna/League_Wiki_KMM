package com.lunabee.remote

import com.lunabee.domain.model.Champion
import com.lunabee.repository.datasource.ChampionRemoteDatasource

class ChampionRemoteDatasourceImpl : ChampionRemoteDatasource {
    override fun getChampionsInfo(): List<Champion> {
        return listOf(
            Champion(
                "1",
                "aatrox",
            ),
            Champion(
                "2",
                "Jhin",
            )
        )
    }
}