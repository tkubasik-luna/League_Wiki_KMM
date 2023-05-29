package com.lunabee.leaguewiki.feature.home

import com.lunabee.domain.model.ChampionInfo
import com.lunabee.leaguewiki.SharedConstants

data class UiChampionInfo(
    val id: String,
    val name: String?,
    val title: String?,
    val imageUrl: String,
    val isFavorite: Boolean,
) {
    companion object {
        fun fromChampionInfo(championInfo: ChampionInfo): UiChampionInfo {
            return UiChampionInfo(
                id = championInfo.id,
                name = championInfo.name,
                title = championInfo.title,
                isFavorite = championInfo.isFavorite,
                imageUrl = getImageUrl(championInfo.version.orEmpty(), championInfo.id)
            )
        }
    }
}

private fun getImageUrl(version: String, id: String): String {
    return "${SharedConstants.Url.BASE_URL}cdn/$version/img/champion/$id.png"
}