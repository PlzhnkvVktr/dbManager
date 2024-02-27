package ru.avem.data.remote.service.news

import ru.avem.data.remote.dto.news.NewsRequest
import ru.avem.data.remote.dto.news.NewsResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
//import io.ktor.client.features.*
//import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.http.*
import ru.avem.data.remote.HttpRoutes
import ru.avem.data.remote.dto.news.NewsActionResponse

class NewsServiceImpl(
    private val client: HttpClient
) : NewsService {

    override suspend fun getNews(): List<NewsResponse> {
        return try {
            client.get(HttpRoutes.NEWS).body()
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

    override suspend fun createNews(newsRequest: NewsRequest) {
        val response = client.post(HttpRoutes.NEWS) {
            contentType(ContentType.Application.Json)
            setBody(newsRequest)
        }
        println("Status CDSDSDSD: ${response.status}")
    }

    override suspend fun deleteNews(id: String): NewsActionResponse =
        client.delete(HttpRoutes.NEWS + "/$id").body()

    override suspend fun updateNews(id: String, newsRequest: NewsRequest) {
        client.put(HttpRoutes.NEWS + "/$id") {
            contentType(ContentType.Application.Json)
            setBody(newsRequest)
        }
    }


}
