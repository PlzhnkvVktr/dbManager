package ru.avem.data.remote.dto.product

import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    val name: String,
    val description: String,
    val characteristic: String,
    val specification: String,
    val additionally: String,
    val category: Int,
    val images: List<String>,
    val id: String
)
