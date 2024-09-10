package com.belia.speedotransfer.ui.main_screens.notifitcation_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.belia.speedotransfer.ui.common_ui.SpeedoNavigationBar
import com.belia.speedotransfer.ui.common_ui.TopBar

@Composable
fun NotificationScreen(
    type: String,
    amount: Float,
    name: String,
    account: String,
    date: String,
    time: String,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold (
        topBar = {
            TopBar(color = Color(0xFFFFF8E7), navController = navController, hasIcon = true, title = "Notifications")
        },
        bottomBar = {
            SpeedoNavigationBar(selectedIndex = 4, navController)
        }
    ) {
        innerPadding ->
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding())
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFFFF8E7), Color(0xFFFFEAEE)),
                    )
                )
        ) {
            LazyColumn {
                items(3) {
                    NotificationItem(
                        type,
                        amount,
                        name,
                        account,
                        date,
                        time
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun NotificationScreenPrev() {
    NotificationScreen(
        type = "Received",
        amount = 1000f,
        name = "Asmaa Dosuky",
        account = "1234 xxx",
        date = "12 Jul 2024",
        time = "09:00 AM",
        navController = rememberNavController()
    )
}