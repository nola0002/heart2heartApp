package com.example.composenavigation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.composenavigation.model.Contact
import com.example.composenavigation.model.Screen

class Heart2HeartViewModel: ViewModel() {

    var contacts by mutableStateOf(
        listOf(
            Contact("Mom", "56214309"),
            Contact("Dad", "34241221"),
            Contact("Sibling", "57329812"),
            Contact("Partner", "44074140"),
            Contact("Bestie", "22203032")
        )
    )

    var hours by mutableStateOf(0)
    var minutes by mutableStateOf(10)
    var seconds by mutableStateOf(0)
    var selectedScreen by mutableStateOf(Screen.Home)

    var newContactName by mutableStateOf("")

    var newPhoneNumber by mutableStateOf("")

    fun addContact(name: String, phoneNumber: String) {
        contacts = contacts + Contact(name = name, phoneNumber = phoneNumber)
    }

    fun deleteContact(contactToDelete: Contact) {
        contacts = contacts - contactToDelete
    }


}