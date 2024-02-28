package ru.avem.composables.common

import androidx.compose.foundation.HorizontalScrollbar
import androidx.compose.foundation.LocalScrollbarStyle
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@Composable
fun ScrollableLazyRow(
    modifier: Modifier = Modifier,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    content: LazyListScope.() -> Unit
) {
    val scrollState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    Box(modifier = modifier) {
        LazyRow(
            modifier = modifier.draggable(
                orientation = Orientation.Horizontal,
                state = rememberDraggableState {
                    scope.launch {
                        scrollState.scrollBy(-it)
                    }
                }
            ),
            horizontalArrangement = horizontalArrangement,
            verticalAlignment = verticalAlignment,
            state = scrollState
        ) {
            content()
        }
        HorizontalScrollbar(
            rememberScrollbarAdapter(scrollState),
            modifier = Modifier.align(Alignment.BottomCenter),
            style = LocalScrollbarStyle.current.copy(
                unhoverColor = MaterialTheme.colors.primary.copy(alpha = .7f),
                hoverColor = MaterialTheme.colors.primary
            )
        )
    }
}