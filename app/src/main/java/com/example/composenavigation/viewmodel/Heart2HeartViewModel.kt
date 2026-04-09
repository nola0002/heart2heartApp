package com.example.composenavigation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.rememberNavController
import com.example.composenavigation.R
import com.example.composenavigation.model.Contact
import com.example.composenavigation.model.Screen

class Heart2HeartViewModel: ViewModel() {

    var contacts by mutableStateOf(
        listOf(
            Contact("Mom"),
            Contact("Dad"),
            Contact("Sibling"),
            Contact("Partner"),
            Contact("Bestie")
        )
    )

    var hours by mutableStateOf(0)
    var minutes by mutableStateOf(10)
    var seconds by mutableStateOf(0)
    var selectedScreen by mutableStateOf(Screen.Home)

}