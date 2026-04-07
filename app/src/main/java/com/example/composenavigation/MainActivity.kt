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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.util.copy
import com.example.composenavigation.ui.theme.ComposeNavigationTheme
import kotlinx.coroutines.flow.filter

class MainActivity : ComponentActivity() {
    @SuppressLint("MutableCollectionMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var contacts by remember {
                mutableStateOf(
                    listOf(
                        Contact("Mom"),
                        Contact("Dad"),
                        Contact("Sibling"),
                        Contact("Partner"),
                        Contact("Bestie")
                    )
                )
            }

            var hours by remember { mutableStateOf(0) }
            var minutes by remember { mutableStateOf(10) }
            var seconds by remember { mutableStateOf(0) }


            CheckInScreen(
                contacts = contacts,
                onContactCheckedChange = { contact, newValue ->
                    contacts = contacts.map {
                        if (it.name == contact.name) it.copy(isChecked = newValue) else it
                    }
                },
                hours = hours,
                minutes = minutes,
                seconds = seconds,
                onChange = {h, m, s ->
                    hours = h
                    minutes = m
                    seconds = s
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
fun CheckInScreen(
    contacts: List<Contact>,
    onContactCheckedChange: (Contact, Boolean) -> Unit,
    hours: Int,
    minutes: Int,
    seconds: Int,
    onChange: (h: Int, m: Int, s: Int) -> Unit
    ){
    Column(
        modifier = Modifier
            .padding(top = 30.dp, bottom = 6.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        val boxWidth = 340

        Text(text = "Check-in", fontSize = 38.sp)


        SelectContacts(contacts, onContactCheckedChange, boxWidth)


        SetTimer(
            boxWidth,
            hours = hours,
            minutes = minutes,
            seconds = seconds,
            onChange = onChange
        )
        NavigationBarBottom({

        })
    }
}

@Composable
fun SelectContacts(
    contacts: List<Contact>,
    onContactCheckedChange: (Contact, Boolean) -> Unit,
    boxWidth: Int
){
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(text = "Select contacts", fontSize = 26.sp, modifier = Modifier.padding(bottom = 16.dp))

        val shape = RoundedCornerShape(12.dp)
        val boxHeight = contacts.size * 60

        Box(
            modifier = Modifier
                .size(width = boxWidth.dp, height = boxHeight.dp)
                .shadow(10.dp, shape, clip = false)
                .clip(shape)
                .background(Color.White)
                .border(1.dp, Color(0xFFFF5AA5), shape)
        ){
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                items(
                    items = contacts,
                    key = {it.name}
                ) { contact ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, top = 12.dp, end = 14.dp, bottom = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(fontSize = 28.sp, text = contact.name)

                        HeartCheckbox(checked = contact.isChecked, onCheckedChange = { newValue ->
                            onContactCheckedChange(contact, newValue)
                        })
                    }
                }
            }
        }
    }
}


@Composable
fun HeartCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(1.dp)

    Box(
        modifier = modifier
            .size(28.dp)
            .border(1.dp, Color.Black, shape)
            .clip(shape)
            .background(Color.Transparent)
            .clickable { onCheckedChange(!checked) },
        contentAlignment = Alignment.Center
    ) {
        if (checked) {
            Image(
                painter = painterResource(R.drawable.heartforcheckbox),
                contentDescription = "checked",
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

@Composable
fun SetTimer(
    boxWidth: Int,
    hours: Int,
    minutes: Int,
    seconds: Int,
    onChange: (h: Int, m: Int, s: Int) -> Unit
){
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Set a timer", fontSize = 26.sp, modifier = Modifier.padding(bottom = 16.dp))

        val shape = RoundedCornerShape(12.dp)
        Box(
            modifier = Modifier
                .size(width = boxWidth.dp, height = 300.dp)
                .shadow(10.dp, shape, clip = false)
                .clip(shape)
                .background(Color.White)
                .border(1.dp, Color.Black, shape)
        ) {
            Column() {
                Row() {

                }

                TimerPicker(
                    hours = hours,
                    minutes = minutes,
                    seconds = seconds,
                    onChange = onChange
                )
            }


        }
    }
}

@Composable
fun NumberWheel(
    values: List<Int>,
    selected: Int,
    onSelectedChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    visibleCount: Int = 3,          // fx 5 rækker synlige
    itemHeight: Dp = 56.dp
) {
    val state = rememberLazyListState()


    // Snap så den lander pænt på et tal
    val flingBehavior = rememberSnapFlingBehavior(lazyListState = state)

    // Start scrolleren ved "selected"
    LaunchedEffect(values, selected) {
        val index = values.indexOf(selected).coerceAtLeast(0)
        state.scrollToItem(index)
    }

    // Lyt efter scroll-stop og opdatér selected
    LaunchedEffect(state) {
        snapshotFlow { state.isScrollInProgress }
            .filter { it == false }
            .collect {
                val index = state.firstVisibleItemIndex
                onSelectedChange(values[index])
            }
    }

    Box(
        modifier = modifier
            .height(itemHeight * visibleCount)
            .width(90.dp),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            state = state,
            flingBehavior = flingBehavior,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(values.size) { i ->
                val v = values[i]
                val isSelected = (v == selected)

                Text(
                    text = v.toString().padStart(2, '0'),
                    fontSize = if (isSelected) 44.sp else 32.sp,
                    color = if (isSelected) Color(0xFF222222) else Color(0xFFCCCCCC),
                    modifier = Modifier.height(itemHeight)
                )
            }
        }

        // Midter "highlight" (valgfrit) – kan være 2 linjer eller et transparent felt
        // fx:
        // Box(Modifier.fillMaxWidth().height(itemHeight).border(1.dp, Color.LightGray))
    }
}

@Composable
fun TimerPicker(
    hours: Int,
    minutes: Int,
    seconds: Int,
    onChange: (h: Int, m: Int, s: Int) -> Unit
) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
        NumberWheel(
            values = (0..99).toList(),
            selected = hours,
            onSelectedChange = { onChange(it, minutes, seconds) }
        )
        NumberWheel(
            values = (0..59).toList(),
            selected = minutes,
            onSelectedChange = { onChange(hours, it, seconds) }
        )
        NumberWheel(
            values = (0..59).toList(),
            selected = seconds,
            onSelectedChange = { onChange(hours, minutes, it) }
        )
    }
}





@Composable
fun HomeScreen(navigateToContactsButtonClick: () -> Unit) {

    Column(
        modifier = Modifier
            .padding(top = 30.dp, bottom = 6.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            modifier = Modifier
                .padding(top = 40.dp, bottom = 140.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Home",
                fontSize = 44.sp
            )

            Image(
                painter = painterResource(id = R.drawable.heart2hearthjerteforhomescreen),
                contentDescription = "heart2heart hjerte",
                modifier = Modifier.size(300.dp)
            )

            Row(
                modifier = Modifier
                    .padding(0.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    modifier = Modifier
                        .padding(end = 40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.greendotbluetooth),
                        contentDescription = "greendot",
                        modifier = Modifier.size(3.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.bluetoothlogo),
                        contentDescription = "bluetooth logo",
                        modifier = Modifier.size(20.dp)
                    )
                    Text("connected")
                }

                Row(
                    modifier = Modifier
                        .padding(0.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.batterylogo),
                        contentDescription = "battery logo",
                        modifier = Modifier.size(20.dp)
                    )
                    Text("95%")
                }
            }
        }


        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF77B7),
                        contentColor = Color.White
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 3.dp,
                        pressedElevation = 1.dp
                    ),
                    modifier = Modifier
                        .height(40.dp)
                        .width(175.dp)
                        .fillMaxWidth(0.82f)
                        .padding(end = 4.dp),
                    onClick = {

                    }
                ) {
                    Text("Create check-in")
                }
                Image(
                    painter = painterResource(id = R.drawable.informationlogo),
                    contentDescription = "information log",
                    modifier = Modifier.size(20.dp)
                )
            }

            Column(
                modifier = Modifier.padding(top = 14.dp, bottom = 40.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFF77B7),
                            contentColor = Color.White
                        ),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 3.dp,
                            pressedElevation = 1.dp
                        ),
                        modifier = Modifier
                            .height(40.dp)
                            .width(175.dp)
                            .fillMaxWidth(0.82f)
                            .padding(end = 4.dp),
                        onClick = {

                        }) {
                        Text("Activate Level 1")
                    }
                    Image(
                        painter = painterResource(id = R.drawable.informationlogo),
                        contentDescription = "information log",
                        modifier = Modifier.size(20.dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .padding(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFF77B7),
                            contentColor = Color.White
                        ),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 3.dp,
                            pressedElevation = 1.dp
                        ),
                        modifier = Modifier
                            .height(40.dp)
                            .width(175.dp)
                            .fillMaxWidth(0.82f)
                            .padding(end = 4.dp),
                        onClick = {

                        }) {
                        Text("Activate Level 2")
                    }
                    Image(
                        painter = painterResource(id = R.drawable.informationlogo),
                        contentDescription = "information log",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            NavigationBarBottom(navigateToContactsButtonClick)
        }
    }
}

@Composable
fun NavigationBarBottom(navigateToContactsButtonClick: () -> Unit) {

    Column() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(1.dp)
                .background(Color.LightGray)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .width(36.dp)
                    .height(6.dp)
                    .offset(x = (+50).dp, y = (-1).dp )
                    .clip(RoundedCornerShape(50))
                    .background(Color(0xFFFF5AA5))
            )
        }

        Row(
            modifier = Modifier
                .padding(0.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier
                    .padding(2.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Black
                    ),
                    onClick = {

                    }) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.heartlogonavgrey),
                            contentDescription = "heart logo for navigation",
                            modifier = Modifier.size(28.dp)
                        )
                        Text("Connect")
                    }
                }


            }

            Column(
                modifier = Modifier
                    .padding(2.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Black
                    ),
                    onClick = {

                    }) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.checkinlogonavgrey),
                            contentDescription = "check in logo for navigation",
                            modifier = Modifier.size(28.dp)
                        )
                        Text("Check-in")
                    }
                }
            }

            Column(
                modifier = Modifier
                    .padding(2.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Black
                    ),
                    onClick = {

                    }) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.homelogonavpink),
                            contentDescription = "home logo for navigation",
                            modifier = Modifier.size(28.dp)
                        )
                        Text(text = "Home", color = Color((0xFFFF5AA5)))
                    }
                }
            }

            Column(
                modifier = Modifier
                    .padding(2.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Black
                    ),
                    onClick = navigateToContactsButtonClick
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.userlogonavngrey),
                            contentDescription = "user logo for navigation",
                            modifier = Modifier.size(28.dp)
                        )
                        Text("Contacts")
                    }
                }
            }
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