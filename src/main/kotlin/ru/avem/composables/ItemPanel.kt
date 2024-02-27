package ru.avem.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ru.avem.composables.common.NavButton

@Composable
fun ItemPanel (
    delete: () -> Unit,
    edit: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NavButton(
            action = { delete() },
            imageVector = Icons.Filled.Delete,
            color = Color.Red
        )
        NavButton(
            action = { edit() },
            imageVector = Icons.Filled.Edit,
            color = Color.Green
        )
    }
}