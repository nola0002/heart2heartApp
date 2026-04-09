package com.example.composenavigation.view.screens.screens.contactsscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composenavigation.model.Contact
import com.example.composenavigation.model.Screen
import com.example.composenavigation.view.everyscreenusage.NavigationBarBottom

@Composable
fun ContactsScreen(
    contacts: List<Contact>,
    onAddContact: (String) -> Unit,
    navigateToConnectButtonClick: () -> Unit,
    navigateToCheckInButtonClick: () -> Unit,
    navigateToHomeButtonClick: () -> Unit,
    navigateToContactsButtonClick: () -> Unit,
    selectedScreen: Screen,
    onScreenClick: (Screen) -> Unit
) {
    var newContactName by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Kontakter",
            fontSize = 32.sp,
            modifier = Modifier.padding(16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = newContactName,
                onValueChange = { newContactName = it },
                label = { Text("Indtast navn") },
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    if (newContactName.isNotBlank()) {
                        onAddContact(newContactName)
                        newContactName = ""
                    }
                }
            ) {
                Text("Tilføj")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

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
                        .padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Text(
                        text = contact.name,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }

        NavigationBarBottom(
            selectedScreen = selectedScreen,
            onScreenClick = onScreenClick,
            navigateToConnectButtonClick = navigateToConnectButtonClick,
            navigateToCheckInButtonClick = navigateToCheckInButtonClick,
            navigateToHomeButtonClick = navigateToHomeButtonClick,
            navigateToContactsButtonClick = navigateToContactsButtonClick
        )
    }
}