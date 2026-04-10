package com.example.composenavigation.view.screens.screens.checkinscreen

import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.flow.filter

@Composable
fun NumberWheel(
    values: List<Int>,
    selected: Int,
    onSelectedChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    visibleCount: Int = 3,      // SKAL være ulige: 3 eller 5
    itemHeight: Dp = 56.dp
) {
    val centerOffset = visibleCount / 2
    val state = rememberLazyListState()
    val flingBehavior = rememberSnapFlingBehavior(lazyListState = state)

    // Start: placer selected i MIDTEN
    LaunchedEffect(values, selected) {
        val idx = values.indexOf(selected).coerceAtLeast(0)
        state.scrollToItem((idx - centerOffset).coerceAtLeast(0))
    }

    // Når scroll stopper: vælg MIDTER item
    LaunchedEffect(state) {
        snapshotFlow { state.isScrollInProgress }
            .filter { it == false }
            .collect {
                val centerIndex =
                    (state.firstVisibleItemIndex + centerOffset)
                        .coerceIn(0, values.lastIndex)

                onSelectedChange(values[centerIndex])
            }
    }

    Box(
        modifier = modifier
            .height(itemHeight * visibleCount)
            .width(90.dp),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            state = state,
            flingBehavior = flingBehavior,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Padding så midten kan ramme et rigtigt tal
            items(centerOffset) { Spacer(Modifier.height(itemHeight)) }

            items(values.size) { i ->
                val v = values[i]
                val isSelected = (v == selected)

                Text(
                    text = v.toString().padStart(2, '0'),
                    fontSize = if (isSelected) 44.sp else 32.sp,
                    color = if (isSelected) Color(0xFF222222) else Color(0xFFCCCCCC),
                    modifier = Modifier.height(itemHeight)
                )
            }

            items(centerOffset) { Spacer(Modifier.height(itemHeight)) }
        }
    }
}