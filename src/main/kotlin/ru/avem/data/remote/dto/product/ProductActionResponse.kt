package ru.avem.data.remote.dto.product

import kotlinx.serialization.Serializable

@Serializable
data class ProductActionResponse(
    val status: Boolean,
    val message: String
)
