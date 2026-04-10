package com.example.composenavigation.view.everyscreenusage

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
import com.example.composenavigation.model.Screen

@Composable
fun NavigationBarBottom(
    selectedScreen: Screen,
    onScreenClick: (Screen) -> Unit
) {
    val pink: Color = Color(0xFFFF5AA5)
    val black: Color = Color.Black


    var homeLogoPink = R.drawable.homelogonavpink
    var homeLogoGrey = R.drawable.homelogonavgrey
    var checkInLogoGrey = R.drawable.checkinlogonavgrey
    val checkInLogoPink = R.drawable.checkinlogonavpink


    val checkInOffset: Int = -49
    val homeOffset: Int = +51
    val contactsOffset: Int = +152


    Column() {
        NavBarDividerLine(offset = if (selectedScreen == Screen.Home) homeOffset else if (selectedScreen == Screen.CheckIn) checkInOffset else contactsOffset)

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Connect
            NavBarElement(
                navigateTo = { onScreenClick(Screen.Connect) },
                color = if (selectedScreen == Screen.Connect) pink else black,
                picture = R.drawable.heartlogonavgrey,
                text = "Connect"
            )

            // Check-in
            NavBarElement(
                navigateTo = { onScreenClick(Screen.CheckIn) },
                color = if (selectedScreen == Screen.CheckIn) pink else black,
                picture = if (selectedScreen == Screen.CheckIn) checkInLogoPink else checkInLogoGrey,
                text = "Check-in"
            )

            // Home
            NavBarElement(
                navigateTo = { onScreenClick(Screen.Home) },
                color = if (selectedScreen == Screen.Home) pink else black,
                picture = if (selectedScreen == Screen.Home) homeLogoPink else homeLogoGrey,
                text = "Home"
            )


            // Contacts
            NavBarElement(
                navigateTo = { onScreenClick(Screen.Contacts) },
                color = if (selectedScreen == Screen.Contacts) pink else black,
                picture = if (selectedScreen == Screen.Contacts) R.drawable.userlogonavpink else R.drawable.userlogonavngrey,
                text = "Contacts"
            )


        }
    }
}

