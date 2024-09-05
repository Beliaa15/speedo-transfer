package com.belia.speedotransfer.ui.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.theme.GrayG0
import com.belia.speedotransfer.ui.theme.GrayG200
import com.belia.speedotransfer.ui.theme.GrayG40
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.bodyMedium16

@Composable
fun RecentTransactions(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Recent Transactions",
                color = GrayG900,
                style = bodyMedium16
            )
            Text(
                text = "View all",
                color = GrayG200,
                style = bodyMedium16,
                modifier = modifier
                    .clickable { /*TODO*/ }
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))

        Box(
            modifier = modifier
                .background(
                    color = GrayG0,
                    shape = RoundedCornerShape(8.dp)
                )
                .clip(RoundedCornerShape(8.dp))
        ) {
            LazyColumn {
                items(10) {
                    TransactionItem(
                        name = "Ahmed Mohamed",
                        cardDetails = "Visa . Master Card . 1234",
                        transactionTime = "Today 11:00",
                        transactionType = "Received",
                        amount = 500,
                        cardIcon = R.drawable.mastercard_logo
                    )
                    HorizontalDivider(
                        color = GrayG40,
                        thickness = 1.dp,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RecentTransactionPreview() {
    RecentTransactions()
}