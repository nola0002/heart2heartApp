package com.example.composenavigation.view.everyscreenusage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NavBarDividerLine(
    offset: Int
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(1.dp)
            .background(Color.LightGray)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .width(36.dp)
                .height(6.dp)
                .offset(x = (offset).dp, y = (-1).dp)
                .clip(RoundedCornerShape(50))
                .background(Color(0xFFFF5AA5))
        )
    }
}