package com.takeda.rickyandmorty.network

import kotlinx.serialization.Serializable

@Serializable
data class RickyAndMortyData (
    val info: InfoData,
    val results: List<resultData>
)

@Serializable
data class InfoData(
    val count: Int,
    val pages: Int,
    val next: String ?= null,
    val prev: String ?= null
)

@Serializable
data class resultData(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin : OriginAndLocationData,
    val location: OriginAndLocationData,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
) {
    @Serializable
    data class OriginAndLocationData (
        val name: String,
        val url: String
    )
}
