package ru.avem.composables.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Textarea(text: MutableState<String>, h: Int) {
    TextField(
        value = text.value,
        onValueChange = { text.value = it }, modifier = Modifier
            .fillMaxWidth()
            .height(h.dp)
            .padding(10.dp)
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
    )
}