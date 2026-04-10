package com.example.composenavigation.view.screens.screens.checkinscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.composenavigation.model.Contact

@Composable
fun SelectContacts(
    contacts: List<Contact>,
    onContactCheckedChange: (Contact, Boolean) -> Unit,
    boxWidth: Int
) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Select contacts",
            fontSize = 26.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        val shape = RoundedCornerShape(12.dp)
        val boxHeight = contacts.size * 60

        Box(
            modifier = Modifier
                .size(width = boxWidth.dp, height = boxHeight.dp)
                .shadow(10.dp, shape, clip = false)
                .clip(shape)
                .background(Color.White)
                .border(1.dp, Color(0xFFFF5AA5), shape)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                items(
                    items = contacts,
                    key = { it.name }
                ) { contact ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, top = 12.dp, end = 14.dp, bottom = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(fontSize = 28.sp, text = contact.name)

                        HeartCheckbox(checked = contact.isChecked, onCheckedChange = { newValue ->
                            onContactCheckedChange(contact, newValue)
                        })


                    }
                }
            }
        }


    }
}