package com.example.composenavigation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composenavigation.R

@Composable
fun NavigationBarBottom(
    navigateToConnectButtonClick: () -> Unit,
    navigateToCheckInButtonClick: () -> Unit,
    navigateToHomeButtonClick: () -> Unit,
    navigateToContactsButtonClick: () -> Unit
) {
    var homeLogo = R.drawable.homelogonavpink
    var checkInLogo = R.drawable.checkinlogonavgrey

    R.drawable.checkinlogonavpink

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
                    .offset(x = (+50).dp, y = (-1).dp)
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
                    onClick = navigateToConnectButtonClick) {
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
                    onClick = navigateToCheckInButtonClick
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = checkInLogo),
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
                    onClick = navigateToHomeButtonClick) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = homeLogo),
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
