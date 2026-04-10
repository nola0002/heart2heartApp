package com.example.composenavigation.view.screens.screens.checkinscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composenavigation.model.Contact
import com.example.composenavigation.model.Screen
import com.example.composenavigation.view.everyscreenusage.NavigationBarBottom


@Composable
fun CheckInScreen(
    contacts: List<Contact>,
    onContactCheckedChange: (Contact, Boolean) -> Unit,
    hours: Int,
    minutes: Int,
    seconds: Int,
    onChange: (h: Int, m: Int, s: Int) -> Unit,
    selectedScreen: Screen,
    onScreenClick: (Screen) -> Unit,
    setCheckInButtonClick: () -> Unit
) {
    val boxWidth = 340

    Scaffold(
        bottomBar = {
            NavigationBarBottom(
                selectedScreen = selectedScreen,
                onScreenClick = onScreenClick
            )
        }
    ) { innerPadding ->


        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (contacts.size > 0) {
                item {
                    Text(
                        text = "Check-in",
                        fontSize = 38.sp,
                        modifier = Modifier.padding(top = 30.dp, bottom = 16.dp)
                    )
                }

                item {
                    SelectContacts(
                        contacts = contacts,
                        onContactCheckedChange = onContactCheckedChange,
                        boxWidth = boxWidth
                    )
                }

                item {
                    SetTimer(
                        boxWidth = boxWidth,
                        hours = hours,
                        minutes = minutes,
                        seconds = seconds,
                        onChange = onChange
                    )
                }

                item { Spacer(Modifier.height(16.dp)) }

                item {
                    Text(
                        text = "If you miss your check-in, we’ll automatically alert your contacts and share your location (Level 1), so they can make sure you’re okay.",
                        modifier = Modifier.padding(32.dp)
                    )
                }

                item { Spacer(Modifier.height(16.dp)) }

                item {
                    PinkButtonCheckInScreen(
                        onClick = setCheckInButtonClick,
                        text = "Set check-in"
                    )
                }

                item { Spacer(Modifier.height(50.dp)) }
            } else {
                item {
                    Text(
                        text = "Check-in",
                        fontSize = 38.sp,
                        modifier = Modifier.padding(top = 30.dp, bottom = 16.dp)
                    )
                }

                item { Spacer(Modifier.height(50.dp)) }

                item { Text(fontSize = 28.sp, text = "Contact list is empty") }

                item { Spacer(Modifier.height(50.dp)) }


            }


        }
    }
}