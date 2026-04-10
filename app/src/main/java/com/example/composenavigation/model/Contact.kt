package com.example.composenavigation.model

data class Contact(
    val name: String,
    val phoneNumber: String,
    var isChecked: Boolean = false
)