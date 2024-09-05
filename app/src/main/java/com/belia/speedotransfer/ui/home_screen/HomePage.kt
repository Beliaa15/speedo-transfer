package com.belia.speedotransfer.ui.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomePage(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFFFF8E7), Color(0xFFFFEAEE)),
                )
            )
    )
    {
        TopSection()
        BalanceCard()
        RecentTransactions()
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomePagePrev() {
    HomePage()
}