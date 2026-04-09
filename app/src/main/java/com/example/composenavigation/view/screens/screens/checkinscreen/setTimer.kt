package com.example.composenavigation.view.screens.screens.checkinscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SetTimer(
    boxWidth: Int,
    hours: Int,
    minutes: Int,
    seconds: Int,
    onChange: (h: Int, m: Int, s: Int) -> Unit
){
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Set a timer", fontSize = 26.sp, modifier = Modifier.padding(bottom = 16.dp))

        val shape = RoundedCornerShape(12.dp)
        Box(
            modifier = Modifier
                .size(width = boxWidth.dp, height = 300.dp)
                .shadow(10.dp, shape, clip = false)
                .clip(shape)
                .background(Color.White)
                .border(1.dp, Color.Black, shape)
        ) {
            Column() {
                Row() {

                }

                TimerPicker(
                    hours = hours,
                    minutes = minutes,
                    seconds = seconds,
                    onChange = onChange
                )
            }


        }
    }
}