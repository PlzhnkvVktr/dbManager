package ru.avem.viewmodels.news

import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.avem.data.remote.service.news.NewsService
import ru.avem.data.remote.dto.news.NewsRequest

class CreateNewsScreenVM(private val navigator: Navigator): ScreenModel {
    private val scope = CoroutineScope(Dispatchers.Default)
    private val service = NewsService.create()

    val title = mutableStateOf("")
    val message = mutableStateOf("")

    fun addNews() {
        scope.launch {
            service.createNews(
                NewsRequest(
                    title = title.value,
                    message = message.value
                )
            )
            navigator.pop()
        }
    }
}