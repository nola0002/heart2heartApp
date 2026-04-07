package com.example.composenavigation.view.checkinscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TimerPicker(
    hours: Int,
    minutes: Int,
    seconds: Int,
    onChange: (h: Int, m: Int, s: Int) -> Unit
) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
        NumberWheel(
            values = (0..99).toList(),
            selected = hours,
            onSelectedChange = { onChange(it, minutes, seconds) }
        )
        NumberWheel(
            values = (0..59).toList(),
            selected = minutes,
            onSelectedChange = { onChange(hours, it, seconds) }
        )
        NumberWheel(
            values = (0..59).toList(),
            selected = seconds,
            onSelectedChange = { onChange(hours, minutes, it) }
        )
    }
}