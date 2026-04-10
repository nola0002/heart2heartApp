package com.example.composenavigation.view.screens.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composenavigation.R

@Composable
fun BluetoothConnection(){
    Row(
        modifier = Modifier
            .padding(end = 40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.greendotbluetooth),
            contentDescription = "greendot",
            modifier = Modifier.size(3.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.bluetoothlogo),
            contentDescription = "bluetooth logo",
            modifier = Modifier.size(20.dp)
        )
        Text("connected")
    }
}