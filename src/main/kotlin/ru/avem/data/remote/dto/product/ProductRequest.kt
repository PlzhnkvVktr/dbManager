package ru.avem.data.remote.dto.product

import kotlinx.serialization.Serializable

@Serializable
data class ProductRequest(
    val name: String,
    val description: String,
    val characteristic: String,
    val specification: String,
    val additionally: String,
    val category: Int,
    val subcategory: Int,
    val images: List<String>
)
