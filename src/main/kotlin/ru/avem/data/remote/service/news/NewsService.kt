package ru.avem.data.remote.service.news

import ru.avem.data.remote.dto.news.NewsRequest
import ru.avem.data.remote.dto.news.NewsResponse
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import ru.avem.data.remote.dto.news.NewsActionResponse

interface NewsService {

    suspend fun getNews(): List<NewsResponse>

    suspend fun createNews(newsRequest: NewsRequest)

    suspend fun deleteNews(id: String): NewsActionResponse

    suspend fun updateNews(id: String, newsRequest: NewsRequest)

    companion object {
        fun create(): NewsService = NewsServiceImpl(
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
