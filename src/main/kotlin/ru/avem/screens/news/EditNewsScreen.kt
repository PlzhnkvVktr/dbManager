package ru.avem.screens.news

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.avem.composables.Header
import ru.avem.composables.common.Textarea
import ru.avem.data.remote.dto.news.NewsResponse
import ru.avem.viewmodels.news.EditNewsScreenVM

class EditNewsScreen(
    private val newsResponse: NewsResponse
) : Screen {

    @Composable
    override fun Content() {
        val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
        val navigator = LocalNavigator.currentOrThrow
        val vm = rememberScreenModel { EditNewsScreenVM(newsResponse, navigator) }

        Scaffold(
            scaffoldState = scaffoldState,
            topBar = { Header("Редактирование новости") },
            content = {

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text("Заголовок")
                    Textarea(
                        text = vm.title,
                        h = 100
                    )
                    Text("Текст новости")
                    Textarea(
                        text = vm.message,
                        h = 700
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = vm::editNews
                        ){
                            Text("Редактировать")
                        }
                    }
                }
            }
        )
    }
}