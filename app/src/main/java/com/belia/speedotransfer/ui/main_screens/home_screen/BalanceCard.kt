package com.belia.speedotransfer.ui.main_screens.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belia.speedotransfer.ui.theme.RedP300
import com.belia.speedotransfer.ui.theme.RedP400
import com.belia.speedotransfer.ui.theme.bodyMedium16
import com.belia.speedotransfer.ui.theme.heading2

@Composable
fun BalanceCard(
    amount: Float,
    modifier: Modifier = Modifier
) {
    Card (
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(124.dp)
            .background(
                brush = Brush.linearGradient(
                    listOf(RedP300, RedP400)
                ),
                shape = RoundedCornerShape(8.dp)
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
    ) {
        Column(
            modifier = modifier
                .padding(horizontal = 16.dp, vertical = 25.dp)

        ) {
            Text(
                text = "Current Balance",
                color = Color(0xFFFFFFFF),
                style = bodyMedium16
            )
            Spacer(modifier = modifier.size(12.dp))
            Text(
                text = "${amount.toInt()} EGP",
                color = Color(0xFFFFFFFF),
                style = heading2
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BalanceCardPreview() {
    BalanceCard(10000f)
}