package com.trackinder.domain.model

data class ResponseUserProfileDomain(
    val country: String?,
    val images: List<ImagesItemDomain>,
    val product: String?,
    val followers: FollowersDomain,
    val href: String?,
    val id: String,
    val displayName: String,
    val type: String,
    val externalUrls: ExternalUrlsDomain,
    val uri: String,
    val email: String?
)

data class ImagesItemDomain(
    val width: Int,
    val url: String?,
    val height: Int
)

data class FollowersDomain(
    val total: Int
)

data class ExternalUrlsDomain(
    val spotify: String?
)