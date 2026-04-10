package com.example.composenavigation.view.screens.screens.contactsscreen

import android.R.attr.shape
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composenavigation.model.Contact
import com.example.composenavigation.model.Screen
import com.example.composenavigation.view.everyscreenusage.NavigationBarBottom

@Composable
fun ContactsScreen(
    contacts: List<Contact>,
    selectedScreen: Screen,
    onScreenClick: (Screen) -> Unit,
    newContactName: String,
    onValueChange: (String) -> Unit,
    onAddButtonClick: () -> Unit,
    onDeleteButtonClick: (Contact) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Contacts",
            fontSize = 50.sp,
            modifier = Modifier.padding(16.dp, top = 40.dp, bottom = 30.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = newContactName,
                onValueChange = onValueChange,
                label = { Text("Enter name") },
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = 10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFFF5AA5),
                    focusedLabelColor = Color(0xFFFF5AA5),
                    unfocusedBorderColor = Color(0xFFFF5AA5)
                )
            )

            Spacer(modifier = Modifier.width(8.dp))

            PinkAddButtonContactsScreen(
                onClick = onAddButtonClick,
                text = "Add"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        val shape = RoundedCornerShape(16.dp)

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            items(contacts) { contact ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .background(Color.White)
                        .border(1.dp, Color(0xFFFF5AA5), shape),
                    shape = shape,
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {
                        Text(
                            text = contact.name,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(16.dp)
                        )

                        PinkDeleteButtonContactsScreen(
                            onClick = { onDeleteButtonClick(contact) },
                            text = "Delete")
                    }

                }
            }
        }

        NavigationBarBottom(
            selectedScreen = selectedScreen,
            onScreenClick = onScreenClick
        )
    }
}