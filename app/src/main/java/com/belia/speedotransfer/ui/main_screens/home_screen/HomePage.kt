package com.belia.speedotransfer.ui.main_screens.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.belia.speedotransfer.ui.common_ui.SpeedoNavigationBar

@Composable
fun HomePage(navController: NavController, modifier: Modifier = Modifier) {
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
            TopSection(name = "Mohaned Emad")
            BalanceCard(1000f)
            RecentTransactions()
        }

    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomePagePrev() {
    HomePage(rememberNavController())
}