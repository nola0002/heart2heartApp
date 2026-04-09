package com.example.composenavigation.view.screens.screens.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composenavigation.model.Screen
import com.example.composenavigation.view.everyscreenusage.NavigationBarBottom

@Composable
fun HomeScreen(
    navigateToConnectButtonClick: () -> Unit,
    navigateToCheckInButtonClick: () -> Unit,
    navigateToHomeButtonClick: () -> Unit,
    navigateToContactsButtonClick: () -> Unit,
    selectedScreen: Screen,
    onScreenClick: (Screen) -> Unit
) {

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

            HeartKeyChainPicture()

            Row(
                modifier = Modifier
                    .padding(0.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                BluetoothConnection()

                BatteryPercentage()
            }
        }


        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PinkButton(
                onClick = {},
                text = "Activate Level 1"
            )
        }

        Column(
            modifier = Modifier.padding(top = 14.dp, bottom = 40.dp)
        ) {
            PinkButton(
                onClick = {},
                text = "Activate Level 1"
            )

            PinkButton(
                onClick = {},
                text = "Activate Level 2"
            )

        }

        NavigationBarBottom(
            selectedScreen = selectedScreen,
            onScreenClick = onScreenClick,
            navigateToConnectButtonClick = navigateToConnectButtonClick,
            navigateToCheckInButtonClick = navigateToCheckInButtonClick,
            navigateToHomeButtonClick = navigateToHomeButtonClick,
            navigateToContactsButtonClick = navigateToContactsButtonClick
        )
    }
}




