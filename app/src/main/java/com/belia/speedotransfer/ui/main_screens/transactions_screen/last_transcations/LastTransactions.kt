package com.belia.speedotransfer.ui.main_screens.transactions_screen.last_transcations

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.belia.speedotransfer.ui.common_ui.SpeedoNavigationBar
import com.belia.speedotransfer.ui.common_ui.TopBar
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.titleSemiBold
import com.belia.speedotransfer.util.formatDate
import com.belia.speedotransfer.viewmodels.SharedViewModel
import com.belia.speedotransfer.viewmodels.UserViewModel

@Composable
fun LastTransactions(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    modifier: Modifier = Modifier,
    viewModel: UserViewModel = viewModel(),
) {
    val userId by sharedViewModel.userId.collectAsState()
    viewModel.getUser(userId)
    val user by viewModel.user.collectAsState()
    val userName = user.name
    val transactions = user.account.transactions
    Log.d("trace", "HomePage: ${user.name}\n${user.account}")
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
                .padding(innerPadding)
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
                items(transactions) { item ->
                    TransactionItem(
                        name = if(item.sender.name == userName)
                            item.recipient.name else item.sender.name,
                        cardDetails = if(item.sender.name == userName)
                            "xxxx xxxx ${item.recipient.accountNumber.takeLast(4)}" else "xxxx xxxx ${item.sender.accountNumber.takeLast(4)}",
                        transactionDate = formatDate(item.createdAt),
                        transactionType = if(item.recipient.name == userName)
                            "Received" else "Sent",
                        transactionAmount = item.amount.toInt().toString(),
                        transactionStatus = item.success,
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
    //LastTransactions(navController = rememberNavController())
}