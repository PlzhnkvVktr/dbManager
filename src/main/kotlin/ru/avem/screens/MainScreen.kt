package ru.avem.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.avem.composables.Header
import ru.avem.screens.news.NewsScreen
import ru.avem.screens.products.ProductsScreen

class MainScreen: Screen {
    @Composable
    override fun Content() {
        val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
        val navigator = LocalNavigator.currentOrThrow
//        val viewModel = rememberScreenModel { ProductsScreenVM() }

        Scaffold(
            scaffoldState = scaffoldState,
            topBar = { Header("Главная") },
            content = {

                Column {
                    Row {
                        Button({
                            navigator.push(NewsScreen())
                        }){
                            Text("Go News")
                        }
                        Button({
                            navigator.push(ProductsScreen())
                        }){
                            Text("Go Products")
                        }
                    }
                }
            },
            bottomBar = {

            }
        )
    }
}