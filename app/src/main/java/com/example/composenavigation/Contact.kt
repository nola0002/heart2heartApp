package com.example.composenavigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class Contact(
    val name: String,
    var isChecked: Boolean = false
)