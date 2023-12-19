package com.kova700.someonesdiary.data.source.unsplash.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoResponse(
    val results: List<Photo>,
    val total: Int,
    @SerialName("total_pages") val totalPages: Int
)

@Serializable
data class Photo(
    val id: String,
    val height: Int,
    val width: Int,
    val urls: Urls
)

@Serializable
data class Urls(
    val full: String,
    val raw: String,
    val regular: String,
    val small: String,
    val thumb: String,
)
