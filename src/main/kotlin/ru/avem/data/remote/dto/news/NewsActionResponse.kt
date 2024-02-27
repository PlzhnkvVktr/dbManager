package ru.avem.data.remote.dto.news

import kotlinx.serialization.Serializable

@Serializable
data class NewsActionResponse(
    val status: Boolean,
    val message: String
)
