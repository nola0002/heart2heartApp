package com.example.composenavigation.view.screens.screens.contactsscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun PinkAddButtonContactsScreen(
    onClick: () -> Unit,
    text: String
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
                .width(100.dp)
                .fillMaxWidth(0.82f)
                .padding(end = 4.dp),
            onClick = onClick
        ) {
            Text(text)
        }
    }
}
