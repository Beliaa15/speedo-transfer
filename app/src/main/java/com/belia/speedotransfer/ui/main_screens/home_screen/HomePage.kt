package com.belia.speedotransfer.ui.main_screens.home_screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.belia.speedotransfer.ui.common_ui.SpeedoNavigationBar
import com.belia.speedotransfer.viewmodels.UserViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.belia.speedotransfer.viewmodels.SharedViewModel

@Composable
fun HomePage(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    modifier: Modifier = Modifier,
    viewModel: UserViewModel = viewModel(),
) {
    val userId by sharedViewModel.userId.collectAsState()
    viewModel.getUser(userId)
    val user by viewModel.user.collectAsState()
    val transactions = user.account.transactions
    Log.d("trace", "HomePage: ${user.name}\n${user.account}")
    //val transactions = user!!.accounts[0].transactions

    Scaffold (
        bottomBar = {
            SpeedoNavigationBar(selectedIndex = 0, navController)
        }
    ) {
        innerPadding->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFFFF8E7), Color(0xFFFFEAEE)),
                    )
                )
                .padding(top = innerPadding.calculateTopPadding())
        )
        {
            TopSection(name = user.name)
            BalanceCard(user.account.balance.toFloat())
            RecentTransactions(navController = navController, transactions = transactions, userName = user.name)
        }

    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomePagePrev() {
    HomePage(rememberNavController(), sharedViewModel = SharedViewModel())
}