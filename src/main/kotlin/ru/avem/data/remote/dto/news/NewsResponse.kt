package ru.avem.data.remote.dto.news

import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    val title: String,
    val message: String,
    val timestamp: Long,
    val id: String
)
