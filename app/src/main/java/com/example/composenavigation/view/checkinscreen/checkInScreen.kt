package com.example.composenavigation.view.checkinscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composenavigation.model.Contact
import com.example.composenavigation.view.NavigationBarBottom

@Composable
fun CheckInScreen(
    contacts: List<Contact>,
    onContactCheckedChange: (Contact, Boolean) -> Unit,
    hours: Int,
    minutes: Int,
    seconds: Int,
    onChange: (h: Int, m: Int, s: Int) -> Unit
){
    Column(
        modifier = Modifier
            .padding(top = 30.dp, bottom = 6.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        val boxWidth = 340

        Text(text = "Check-in", fontSize = 38.sp)


        SelectContacts(contacts, onContactCheckedChange, boxWidth)


        SetTimer(
            boxWidth,
            hours = hours,
            minutes = minutes,
            seconds = seconds,
            onChange = onChange
        )
        NavigationBarBottom({

        })
    }
}