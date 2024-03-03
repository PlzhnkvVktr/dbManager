package ru.avem.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.avem.composables.common.DrawerMenuItem
import ru.avem.enums.Category

@Composable
fun Drawer(
    productsByCategory: () -> Unit
) {

    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Категории товаров",
                    fontSize = 26.sp
                )
            }
        }
        Divider()
        LazyColumn {
            items(Category.values) {
                DrawerMenuItem(it.title) {
                    Category.currentCategoryIndex.value = it.index
                    productsByCategory()
                }
                Divider()
            }
        }
    }
}
