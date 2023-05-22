package com.lunabee.leaguewiki

import com.lunabee.domain.model.TestData
import com.lunabee.repository.ChampionRepositoryImpl

class Greeting {
    private val platform: Platform = getPlatform()
    private val championRepository = ChampionRepositoryImpl()

    fun greet(): String {
        return TestData().toString() //"Hello, ${platform.name}!"
    }
}