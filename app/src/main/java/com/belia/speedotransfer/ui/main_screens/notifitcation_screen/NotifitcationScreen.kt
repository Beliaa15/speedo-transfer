package com.belia.speedotransfer.ui.main_screens.notifitcation_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.belia.speedotransfer.ui.common_ui.SpeedoNavigationBar
import com.belia.speedotransfer.ui.common_ui.TopBar
import com.belia.speedotransfer.util.formatDate
import com.belia.speedotransfer.viewmodels.SharedViewModel
import com.belia.speedotransfer.viewmodels.UserViewModel

@Composable
fun NotificationScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    modifier: Modifier = Modifier,
    viewModel: UserViewModel = viewModel()
) {
    val userId by sharedViewModel.userId.collectAsState()
    viewModel.getUser(userId)
    val user by viewModel.user.collectAsState()
    val transactions = user.account.transactions
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
                items(transactions) { item -> 
                    NotificationItem(
                        type = if(item.senderName == user.name)
                            "Sent" else "Received",
                        amount = item.amount,
                        name = if(item.senderName == user.name)
                            item.recipientName else item.senderName,
                        account = if(item.senderName == user.name)
                            item.recipientAccount else item.senderAccount,
                        date = formatDate(item.createdAt),
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun NotificationScreenPrev() {
//    NotificationScreen(
//        type = "Received",
//        amount = 1000f,
//        name = "Asmaa Dosuky",
//        account = "1234 xxx",
//        date = "12 Jul 2024",
//        time = "09:00 AM",
//        navController = rememberNavController()
//    )
}