package com.belia.speedotransfer.ui.main_screens.my_cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.common_ui.SpeedoNavigationBar
import com.belia.speedotransfer.ui.common_ui.TopBar
import com.belia.speedotransfer.ui.main_screens.home_screen.BalanceCard
import com.belia.speedotransfer.ui.main_screens.home_screen.RecentTransactions
import com.belia.speedotransfer.ui.main_screens.home_screen.TopSection
import com.belia.speedotransfer.ui.theme.RedP200
import com.belia.speedotransfer.ui.theme.RedP300
import com.belia.speedotransfer.ui.theme.RedP400
import com.belia.speedotransfer.ui.theme.bodyMedium16
import com.belia.speedotransfer.ui.theme.bodyRegular16
import com.belia.speedotransfer.ui.theme.heading2
import com.belia.speedotransfer.ui.theme.heading3
import com.belia.speedotransfer.ui.theme.titleMedium
import com.belia.speedotransfer.ui.theme.titleSemiBold
import com.belia.speedotransfer.viewmodels.SharedViewModel
import com.belia.speedotransfer.viewmodels.UserViewModel

@Composable
fun MyCardsScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    modifier: Modifier = Modifier,
    viewModel: UserViewModel = viewModel(),
) {
    val userId by sharedViewModel.userId.collectAsState()
    viewModel.getUser(userId)
    val user by viewModel.user.collectAsState()

    Scaffold(
        topBar = {
            TopBar(
                color = Color(0xFFFFF8E7),
                navController = navController,
                title = "My Cards",
                hasIcon = true
            )
        },
        bottomBar = {
            SpeedoNavigationBar(selectedIndex = 0, navController)
        }
    ) { innerPadding ->
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
            Spacer(modifier = Modifier.height(20.dp))
            MyCard(
                amount = user.account.balance.toFloat(),
                account = user.account.accountNumber,
                name = user.name
            )
        }

    }

}


@Composable
fun MyCard(
    amount: Float = 100000f,
    account: String = "321321321",
    name: String = "7enksh",
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(200.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        listOf(RedP300, RedP400)
                    )
                ),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${amount.toInt()} EGP",
                    color = Color(0xFFFFFFFF),
                    style = heading3,
                )
                Image(
                    painter = painterResource(id = R.drawable.mastercard_logo),
                    contentDescription = "",
                    modifier = modifier.size(70.dp)
                )
            }
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "**** **** **** ${account.takeLast(4)}",
                    color = Color.White,
                    style = titleMedium
                )
                Text(
                    text = name,
                    color = Color.White,
                    style = titleSemiBold
                )

            }
        }
    }
}


@Preview
@Composable
private fun MyCardsScreenPreview() {
    MyCard()
}