package ru.avem.composables.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SubmitButton (
    text: String,
    color: Color = MaterialTheme.colors.secondary,
    enabled: Boolean = true,
    action: () -> Unit
) {
    Button(
        onClick = { action() },
        modifier = Modifier
            .height(50.dp)
            .width(250.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = color, contentColor = Color.Black),
        shape = MaterialTheme.shapes.small.copy(CornerSize(percent = 40)),
        enabled = enabled
    ) {
        Text(
            text = text,
            fontSize = 24.sp
            )
    }
}