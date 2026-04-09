package com.example.composenavigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composenavigation.model.Screen
import com.example.composenavigation.view.screens.screens.checkinscreen.CheckInScreen
import com.example.composenavigation.view.screens.screens.contactsscreen.ContactsScreen
import com.example.composenavigation.view.screens.screens.homescreen.HomeScreen
import com.example.composenavigation.viewmodel.Heart2HeartViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("MutableCollectionMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val heart2HeartViewModel = viewModel<Heart2HeartViewModel>()


            val navController = rememberNavController()
            Column() {
                NavHost(navController = navController, startDestination = "home-screen") {
                    composable("home-screen") {
                        HomeScreen(
                            navigateToConnectButtonClick = {},
                            navigateToCheckInButtonClick = { navController.navigate("checkin-screen") },
                            navigateToHomeButtonClick = { navController.navigate("home-screen") },
                            navigateToContactsButtonClick = { navController.navigate("contacts-screen") },
                            selectedScreen = heart2HeartViewModel.selectedScreen,
                            onScreenClick = { screen ->
                                heart2HeartViewModel.selectedScreen = screen
                                when (screen) {
                                    Screen.Connect -> {}
                                    Screen.CheckIn -> navController.navigate("checkin-screen")
                                    Screen.Home -> navController.navigate("home-screen")
                                    Screen.Contacts -> navController.navigate("contacts-screen")
                                }
                            }
                        )
                    }

                    composable("checkin-screen") {

                        CheckInScreen(
                            contacts = heart2HeartViewModel.contacts,
                            onContactCheckedChange = { contact, newValue ->
                                heart2HeartViewModel.contacts = heart2HeartViewModel.contacts.map {
                                    if (it.name == contact.name) it.copy(isChecked = newValue) else it
                                }
                            },
                            hours = heart2HeartViewModel.hours,
                            minutes = heart2HeartViewModel.minutes,
                            seconds = heart2HeartViewModel.seconds,
                            onChange = { h, m, s ->
                                heart2HeartViewModel.hours = h
                                heart2HeartViewModel.minutes = m
                                heart2HeartViewModel.seconds = s
                            },
                            navigateToConnectButtonClick = {},
                            navigateToCheckInButtonClick = { navController.navigate("checkin-screen") },
                            navigateToHomeButtonClick = { navController.navigate("home-screen") },
                            navigateToContactsButtonClick = { navController.navigate("contacts-screen") },
                            selectedScreen = heart2HeartViewModel.selectedScreen,
                            onScreenClick = { screen ->
                                heart2HeartViewModel.selectedScreen = screen
                                when (screen) {
                                    Screen.Connect -> {}
                                    Screen.CheckIn -> navController.navigate("checkin-screen")
                                    Screen.Home -> navController.navigate("home-screen")
                                    Screen.Contacts -> navController.navigate("contacts-screen")
                                }
                            }
                        )
                    }

                    composable("contacts-screen") {
                        ContactsScreen(
                            contacts = heart2HeartViewModel.contacts,
                            onAddContact = { newName ->

                                heart2HeartViewModel.addContact(newName)
                            },
                            navigateToConnectButtonClick = {},
                            navigateToCheckInButtonClick = { navController.navigate("checkin-screen") },
                            navigateToHomeButtonClick = { navController.navigate("home-screen") },
                            navigateToContactsButtonClick = { navController.navigate("contacts-screen") },
                            selectedScreen = heart2HeartViewModel.selectedScreen,
                            onScreenClick = { screen ->
                                heart2HeartViewModel.selectedScreen = screen
                                when (screen) {
                                    Screen.Connect -> {}
                                    Screen.CheckIn -> navController.navigate("checkin-screen")
                                    Screen.Home -> navController.navigate("home-screen")
                                    Screen.Contacts -> navController.navigate("contacts-screen")
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}





