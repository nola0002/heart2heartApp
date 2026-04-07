package com.example.composenavigation.view.checkinscreen

import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
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
    visibleCount: Int = 3,          // fx 5 rækker synlige
    itemHeight: Dp = 56.dp
) {
    val state = rememberLazyListState()


    // Snap så den lander pænt på et tal
    val flingBehavior = rememberSnapFlingBehavior(lazyListState = state)

    // Start scrolleren ved "selected"
    LaunchedEffect(values, selected) {
        val index = values.indexOf(selected).coerceAtLeast(0)
        state.scrollToItem(index)
    }

    // Lyt efter scroll-stop og opdatér selected
    LaunchedEffect(state) {
        snapshotFlow { state.isScrollInProgress }
            .filter { it == false }
            .collect {
                val index = state.firstVisibleItemIndex
                onSelectedChange(values[index])
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
        }

        // Midter "highlight" (valgfrit) – kan være 2 linjer eller et transparent felt
        // fx:
        // Box(Modifier.fillMaxWidth().height(itemHeight).border(1.dp, Color.LightGray))
    }
}