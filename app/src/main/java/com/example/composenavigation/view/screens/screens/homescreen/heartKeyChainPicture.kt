package com.example.composenavigation.view.screens.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composenavigation.R

@Composable
fun HeartKeyChainPicture(){
    Image(
        painter = painterResource(id = R.drawable.heart2hearthjerteforhomescreen),
        contentDescription = "heart2heart hjerte",
        modifier = Modifier.size(300.dp)
    )
}