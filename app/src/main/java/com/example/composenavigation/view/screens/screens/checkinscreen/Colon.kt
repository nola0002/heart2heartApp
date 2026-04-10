package com.example.composenavigation.view.screens.screens.checkinscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Colon(height: Dp) {
    Box(
        modifier = Modifier.height(height).width(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(":", fontSize = 44.sp, color = Color(0xFF222222))
    }
}