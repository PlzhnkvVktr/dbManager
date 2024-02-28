package ru.avem.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ru.avem.enums.Category

@Composable
fun ProductTopBar (
    list: List<Category>
) {

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        LazyRow {
            items(list) {
                Button({}){
                    Text(it.title)
                }
            }
        }
    }
}