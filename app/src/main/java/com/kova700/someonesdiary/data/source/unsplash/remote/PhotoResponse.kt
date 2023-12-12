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
    @SerialName("blur_hash") val blurHash: String,
    @SerialName("created_at") val createdAt: String,
    @SerialName("current_user_collections") val currentUserCollections: List<CurrentUserCollection>,
    @SerialName("liked_by_user") val likedByUser: Boolean,
    val description: String,
    val color: String,
    val height: Int,
    val width: Int,
    val likes: Int,
    val links: Links,
    val urls: Urls,
    val user: User
)

@Serializable
data class CurrentUserCollection(
    @SerialName("cover_photo") val coverPhoto: CoverPhoto? = null,
    val id: Int,
    @SerialName("last_collected_at") val lastCollectedAt: String,
    @SerialName("published_at") val publishedAt: String,
    val title: String,
    @SerialName("updated_at") val updatedAt: String,
    val user: User? = null
)

@Serializable
data class CoverPhoto(
    @SerialName("blur_hash") val blurHash: String,
    val color: String,
    val description: String,
    val height: Int,
    val id: String,
    @SerialName("liked_by_user") val likedByUser: Boolean,
    val likes: Int,
    val links: Links,
    val urls: Urls,
    val user: User,
    val width: Int
)


@Serializable
data class Links(
    val download: String,
    val html: String,
    val self: String
)

@Serializable
data class Urls(
    val full: String,
    val raw: String,
    val regular: String,
    val small: String,
    val thumb: String
)

@Serializable
data class User(
    @SerialName("first_name") val firstName: String,
    val id: String,
    @SerialName("instagram_username") val instagramUsername: String,
    @SerialName("last_name") val lastName: String,
    val links: LinksX,
    val name: String,
    @SerialName("portfolio_url") val portfolioUrl: String,
    @SerialName("profile_image") val profileImage: ProfileImage,
    @SerialName("twitter_username") val twitterUsername: String,
    val username: String
)

@Serializable
data class LinksX(
    val html: String,
    val likes: String,
    val photos: String,
    val self: String
)

@Serializable
data class ProfileImage(
    val large: String,
    val medium: String,
    val small: String
)