package ru.avem.screens.news

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.avem.composables.ItemsScreenBottomBar
import ru.avem.composables.Header
import ru.avem.composables.ItemPanel
import ru.avem.viewmodels.news.NewsScreenVM

class NewsScreen() : Screen {

    @Composable
    override fun Content() {
        val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
        val navigator = LocalNavigator.currentOrThrow
        val vm = rememberScreenModel { NewsScreenVM() }

        LaunchedEffect(Unit) {
            vm.getNews()
        }

        Scaffold(
            scaffoldState = scaffoldState,
            topBar = { Header("Список новостей") },
            content = {
                Column {
                    if (vm.news.value == null) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .fillMaxSize(.5f)
                        )
                    } else {
                        LazyColumn {
                            items(vm.news.value!!) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(150.dp)
                                        .padding(15.dp)
                                        .border(1.dp, Color.LightGray)
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth(.95f)
                                            .fillMaxHeight()
                                            .border(1.dp, Color.LightGray)
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            horizontalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                text = it.title,
                                                fontSize = 20.sp,
                                                modifier = Modifier
                                                    .padding(top = 15.dp)
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(20.dp))
                                        Text(
                                            text = it.message,
                                            fontSize = 14.sp,
                                            modifier = Modifier
                                                .padding(start = 5.dp)
                                        )
                                    }
                                    ItemPanel(
                                        delete = { vm.deleteNews(it.id) },
                                        edit = { navigator.push(EditNewsScreen(it)) }
                                    )
                                }
                            }
                        }
                    }
                }
            },
            bottomBar = {
                ItemsScreenBottomBar { navigator.push(CreateNewsScreen()) }
            }
        )
    }
}