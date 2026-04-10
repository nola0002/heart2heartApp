package com.example.composenavigation.view.screens.screens.checkinscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PinkButtonCheckInScreen(
    onClick: () -> Unit,
    text: String
){
    Button(
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFF77B7),
            contentColor = Color.White
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 3.dp,
            pressedElevation = 1.dp
        ),
        modifier = Modifier
            .height(54.dp)
            .width(250.dp)
            .fillMaxWidth(0.82f)
            .padding(),
        onClick = onClick) {
        Text(
            text = text,
            fontSize = 22.sp,
            fontWeight = FontWeight.Normal
            )
    }
}