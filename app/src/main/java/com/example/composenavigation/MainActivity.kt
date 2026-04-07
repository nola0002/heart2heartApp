package com.example.composenavigation

import android.R.attr.checked
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.util.copy
import com.example.composenavigation.model.Contact
import com.example.composenavigation.ui.theme.ComposeNavigationTheme
import com.example.composenavigation.view.NavigationBarBottom
import com.example.composenavigation.view.checkinscreen.CheckInScreen
import com.example.composenavigation.viewmodel.Heart2HeartViewModel
import kotlinx.coroutines.flow.filter

class MainActivity : ComponentActivity() {
    @SuppressLint("MutableCollectionMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val Heart2HeartViewModel = viewModel< Heart2HeartViewModel>();




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
                onChange = {h, m, s ->
                    Heart2HeartViewModel.hours = h
                    Heart2HeartViewModel.minutes = m
                    Heart2HeartViewModel.seconds = s
                })



            /*
            val navController = rememberNavController()
            Column() {
                NavHost(navController = navController, startDestination = "home-screen") {
                    composable("home-screen") {
                        HomeScreen({
                            navController.navigate("contacts-screen")
                        })
                    }

                    composable("contacts-screen") {
                        ContactsScreen({
                            navController.popBackStack()
                        })
                    }


             */

                }
            }
        }







@Composable
fun ContactsScreen(onBackButtonClick: () -> Unit) {
    Column {
        Text(
            text = "Contacts screen!",
            fontSize = 32.sp
        )
        Button(onClick = onBackButtonClick) {
            Text("Back")
        }
    }
}