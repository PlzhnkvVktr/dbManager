package ru.avem.data.remote.service.product

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import ru.avem.data.remote.dto.product.ProductActionResponse
import ru.avem.data.remote.dto.product.ProductRequest
import ru.avem.data.remote.dto.product.ProductResponse

interface ProductService {

    suspend fun getProducts(): List<ProductResponse>

    suspend fun getProductsByCategory(category: Int): List<ProductResponse>?

    suspend fun createProduct(productRequest: ProductRequest)

    suspend fun deleteProduct(id: String): ProductActionResponse

    suspend fun updateProduct(id: String, productRequest: ProductRequest)

    companion object {
        fun create(): ProductService = ProductServiceImpl(
            client = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                })
            }
            install(Logging) {
                level = LogLevel.ALL
            }
        })
    }
}
