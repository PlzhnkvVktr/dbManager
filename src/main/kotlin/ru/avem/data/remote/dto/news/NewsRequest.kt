package ru.avem.data.remote.dto.news

import kotlinx.serialization.Serializable

@Serializable
data class NewsRequest(
    val title: String,
    val message: String
)
