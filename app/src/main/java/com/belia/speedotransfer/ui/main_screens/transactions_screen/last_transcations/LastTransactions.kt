package com.belia.speedotransfer.ui.main_screens.transactions_screen.last_transcations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.common_ui.SpeedoNavigationBar
import com.belia.speedotransfer.ui.common_ui.TopBar
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.titleSemiBold

@Composable
fun LastTransactions(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold (
        topBar = {
            TopBar(color = Color(0xFFFFF8E7), navController, hasIcon = true, title = "Transactions")
        },
        bottomBar = {
            SpeedoNavigationBar(selectedIndex = 2, navController)
        }
    ) {
        innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFFFF8E7), Color(0xFFFFEAEE)),
                    )
                )
                .padding(top = innerPadding.calculateTopPadding())
        ) {
            Text(
                text = "Your Last Transactions",
                color = GrayG900,
                style = titleSemiBold,
                modifier = modifier.padding(vertical = 16.dp)
            )
            LazyColumn (
                modifier = modifier.padding(16.dp)
            ) {
                items(3) {
                    TransactionItem(
                        name = "Ahmed Mohamed",
                        cardDetails = "Visa . Master Card . 1234",
                        transactionTime = "10:00",
                        transactionDate = "Today",
                        transactionType = "Received",
                        transactionAmount = "1000",
                        transactionStatus = "Successful"
                    )
                    Spacer(modifier = modifier.padding(8.dp))
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun LastTransactionsPrev() {
    LastTransactions(navController = rememberNavController())
}