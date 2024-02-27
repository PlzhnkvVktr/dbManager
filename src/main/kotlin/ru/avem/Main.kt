package ru.avem

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import cafe.adriel.voyager.navigator.Navigator
import ru.avem.screens.MainScreen

@Composable
@Preview
fun App() {

//    val service = PostsService.create()
//    val posts = produceState<List<PostResponse>>(
//        initialValue = emptyList(),
//        producer = {
//            value = service.getPosts()
//        }
//    )



    MaterialTheme {
        Navigator(
            screen = MainScreen()
//            screen = NewsScreen()
        )
    }
}

fun main() = application {
    val windowState = rememberWindowState(placement = WindowPlacement.Maximized)
    Window(onCloseRequest = ::exitApplication, undecorated = true, resizable = false, state = windowState) {
        App()
    }
}
