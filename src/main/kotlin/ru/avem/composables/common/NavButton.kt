package ru.avem.composables.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun NavButton (
    action: () -> Unit,
    imageVector: ImageVector,
    color: Color
) {
    IconButton(
        onClick = { action() },
        modifier = Modifier
//            .border(2.dp, Color.Black)
    ) {
        Icon(
            imageVector,
            modifier = Modifier.size(60.dp).padding(horizontal = 10.dp),
            tint = color,
            contentDescription = null
        )
    }
}