package com.example.composenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composenavigation.ui.theme.ComposeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            HomeScreen({

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
fun CheckInScreen(){



    NavigationBarBottom({

    })
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