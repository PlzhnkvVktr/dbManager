package ru.avem.data.remote.service.product

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.http.*
import ru.avem.data.remote.HttpRoutes
import ru.avem.data.remote.dto.product.ProductActionResponse
import ru.avem.data.remote.dto.product.ProductRequest
import ru.avem.data.remote.dto.product.ProductResponse

class ProductServiceImpl(
    private val client: HttpClient
) : ProductService {

    override suspend fun getProducts(): List<ProductResponse> {
        return try {
            client.get(HttpRoutes.PRODUCTS).body()
        } catch(e: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: ClientRequestException) {
            // 4xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: ServerResponseException) {
            // 5xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: Exception) {
            println("Error: ${e.message}")
            emptyList()
        }
    }

    override suspend fun getProductsByCategory(category: Int): List<ProductResponse> {
        return try {
            client.get(HttpRoutes.PRODUCTS_CATEGORY + "/$category").body()
        } catch(e: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: ClientRequestException) {
            // 4xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: ServerResponseException) {
            // 5xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: Exception) {
            println("Error: ${e.message}")
            emptyList()
        }
    }

    override suspend fun createProduct(productRequest: ProductRequest) {
        client.post(HttpRoutes.PRODUCTS) {
            contentType(ContentType.Application.Json)
            setBody(productRequest)
        }
    }

    override suspend fun deleteProduct(id: String): ProductActionResponse =
        client.delete(HttpRoutes.PRODUCTS + "/$id").body()

    override suspend fun updateProduct(id: String, productRequest: ProductRequest) {
        client.put(HttpRoutes.PRODUCTS + "/$id") {
            contentType(ContentType.Application.Json)
            setBody(productRequest)
        }
    }


}
