package ru.avem.viewmodels.news

import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.avem.data.remote.service.news.NewsService
import ru.avem.data.remote.dto.news.NewsRequest
import ru.avem.data.remote.dto.news.NewsResponse

class EditNewsScreenVM(
    private val newsResponse: NewsResponse,
    private val navigator: Navigator
) : ScreenModel {

    private val scope = CoroutineScope(Dispatchers.IO)
    private val service = NewsService.create()

    val title = mutableStateOf(newsResponse.title)
    val message = mutableStateOf(newsResponse.message)

    fun editNews(){
        scope.launch {
            service.updateNews(
                id = newsResponse.id,
                newsRequest = NewsRequest(
                    title = title.value,
                    message = message.value
                )
            )
            navigator.pop()
        }
    }
}