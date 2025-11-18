package com.example.amjadcomposeapp.domain.models

import kotlinx.serialization.Serializable

@Serializable
enum class MediaType { AUDIO, VIDEO, ARTICLES }
@Serializable
data class MediaModel(
    val id: String,
    val name: String,
    val title: String,
    val description: String,
    val type: MediaType,
    val url:String,
    val thumbnailUrl:Int?
)
