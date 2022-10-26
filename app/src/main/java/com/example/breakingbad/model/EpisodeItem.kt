package com.example.breakingbad.model


import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Serializable
@Immutable
data class EpisodeItem(
    val airDate: String? = null,
    val characters: List<String>,
    val episode: String,
    val episodeId: Int?= null,
    val season: String,
    val series: String,
    val title: String
)