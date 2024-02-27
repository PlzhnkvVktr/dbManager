package ru.avem.viewmodels.news

import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.avem.data.remote.service.news.NewsService
import ru.avem.data.remote.dto.news.NewsResponse

class NewsScreenVM : ScreenModel {
    private val scope = CoroutineScope(Dispatchers.Default)

    private val service = NewsService.create()
    var news = mutableStateOf<List<NewsResponse>?>(null)

    suspend fun getNews() {
        news.value = service.getNews()
    }

    fun deleteNews(id: String) {
        scope.launch {
            service.deleteNews(id)
            getNews()
        }
    }
}