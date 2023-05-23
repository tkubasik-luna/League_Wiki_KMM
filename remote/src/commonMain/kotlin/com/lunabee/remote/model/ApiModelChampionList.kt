package com.lunabee.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiModelChampionList(
    val format: String,
    val type: String,
    val version: String,
    val data: Map<String, ApiChampion>,
)

@Serializable
data class ApiChampion(
    val blurb: String?,
    val id: String,
    val key: String?,
    val name: String?,
    val partype: String?,
    val tags: List<String>?,
    val title: String?,
    val version: String?,
)

