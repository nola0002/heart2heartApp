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
            val Heart2HeartViewModel = viewModel<Heart2HeartViewModel>();


            val navController = rememberNavController()
            Column() {
                NavHost(navController = navController, startDestination = "home-screen") {
                    composable("home-screen") {
                        HomeScreen(
                            navigateToConnectButtonClick = {},
                            navigateToCheckInButtonClick = { navController.navigate("checkin-screen") },
                            navigateToHomeButtonClick = { navController.navigate("home-screen") },
                            navigateToContactsButtonClick = { navController.navigate("contacts-screen") },
                            selectedScreen = Heart2HeartViewModel.selectedScreen,
                            onScreenClick = { screen ->
                                Heart2HeartViewModel.selectedScreen = screen
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
                            contacts = Heart2HeartViewModel.contacts,
                            onContactCheckedChange = { contact, newValue ->
                                Heart2HeartViewModel.contacts = Heart2HeartViewModel.contacts.map {
                                    if (it.name == contact.name) it.copy(isChecked = newValue) else it
                                }
                            },
                            hours = Heart2HeartViewModel.hours,
                            minutes = Heart2HeartViewModel.minutes,
                            seconds = Heart2HeartViewModel.seconds,
                            onChange = { h, m, s ->
                                Heart2HeartViewModel.hours = h
                                Heart2HeartViewModel.minutes = m
                                Heart2HeartViewModel.seconds = s
                            },
                            navigateToConnectButtonClick = {},
                            navigateToCheckInButtonClick = { navController.navigate("checkin-screen") },
                            navigateToHomeButtonClick = { navController.navigate("home-screen") },
                            navigateToContactsButtonClick = { navController.navigate("contacts-screen") },
                            selectedScreen = Heart2HeartViewModel.selectedScreen,
                            onScreenClick = { screen ->
                                Heart2HeartViewModel.selectedScreen = screen
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
                            navigateToConnectButtonClick = {},
                            navigateToCheckInButtonClick = { navController.navigate("checkin-screen") },
                            navigateToHomeButtonClick = { navController.navigate("home-screen") },
                            navigateToContactsButtonClick = { navController.navigate("contacts-screen") },
                            selectedScreen = Heart2HeartViewModel.selectedScreen,
                            onScreenClick = { screen ->
                                Heart2HeartViewModel.selectedScreen = screen
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





