package com.example.composenavigation.view.screens.screens.checkinscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TimerPicker(
    hours: Int,
    minutes: Int,
    seconds: Int,
    onChange: (h: Int, m: Int, s: Int) -> Unit
) {
    val visibleCount = 3
    val itemHeight = 56.dp
    val wheelHeight = itemHeight * visibleCount
    val wheelWidth = 90.dp

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        // Labels over hver kolonne
        Row(
            modifier = Modifier.width(wheelWidth * 3 + 20.dp * 2), // 3 wheels + 2 colons
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Hours", color = Color.Gray, fontSize = 16.sp,
                modifier = Modifier.width(wheelWidth)
                .padding(10.dp), textAlign = TextAlign.Center)
            Text("Minutes", color = Color.Gray, fontSize = 16.sp,
                modifier = Modifier.width(wheelWidth)
                    .padding(10.dp), textAlign = TextAlign.Center)
            Text("Seconds", color = Color.Gray, fontSize = 16.sp,
                modifier = Modifier.width(wheelWidth)
                    .padding(10.dp), textAlign = TextAlign.Center)
        }

        Spacer(Modifier.height(8.dp))

        // Wheels + ":" imellem
        Row(verticalAlignment = Alignment.CenterVertically) {

            NumberWheel(
                values = (0..99).toList(),
                selected = hours,
                onSelectedChange = { onChange(it, minutes, seconds) },
                visibleCount = visibleCount,
                itemHeight = itemHeight,
                modifier = Modifier.width(wheelWidth)
            )

            Colon(height = wheelHeight)

            NumberWheel(
                values = (0..59).toList(),
                selected = minutes,
                onSelectedChange = { onChange(hours, it, seconds) },
                visibleCount = visibleCount,
                itemHeight = itemHeight,
                modifier = Modifier.width(wheelWidth)
            )

            Colon(height = wheelHeight)

            NumberWheel(
                values = (0..59).toList(),
                selected = seconds,
                onSelectedChange = { onChange(hours, minutes, it) },
                visibleCount = visibleCount,
                itemHeight = itemHeight,
                modifier = Modifier.width(wheelWidth)
            )
        }
    }
}

