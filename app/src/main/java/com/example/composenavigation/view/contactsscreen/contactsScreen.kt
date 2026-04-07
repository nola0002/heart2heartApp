package com.example.composenavigation.view.contactsscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.example.composenavigation.view.NavigationBarBottom

@Composable
fun ContactsScreen(
    navigateToConnectButtonClick: () -> Unit,
    navigateToCheckInButtonClick: () -> Unit,
    navigateToHomeButtonClick: () -> Unit,
    navigateToContactsButtonClick: () -> Unit
) {
    Column {
        Text(
            text = "Contacts screen!",
            fontSize = 32.sp
        )
        NavigationBarBottom(
            navigateToConnectButtonClick = navigateToConnectButtonClick,
            navigateToCheckInButtonClick = navigateToCheckInButtonClick,
            navigateToHomeButtonClick = navigateToHomeButtonClick,
            navigateToContactsButtonClick = navigateToContactsButtonClick
        )
    }
}