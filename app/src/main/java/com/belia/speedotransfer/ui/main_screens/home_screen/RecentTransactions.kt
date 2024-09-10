package com.belia.speedotransfer.ui.main_screens.home_screen

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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.belia.speedotransfer.R
import com.belia.speedotransfer.model.Transaction
import com.belia.speedotransfer.navigation.AppRoutes
import com.belia.speedotransfer.ui.theme.GrayG0
import com.belia.speedotransfer.ui.theme.GrayG200
import com.belia.speedotransfer.ui.theme.GrayG40
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.bodyMedium16
import com.belia.speedotransfer.util.formatDate

@Composable
fun RecentTransactions(
    navController: NavController,
    modifier: Modifier = Modifier,
    transactions: List<Transaction> = emptyList(),
    userName : String = "",
) {
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
                    .clickable { navController.navigate(AppRoutes.TRANSACTIONS) }
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
                items(transactions) { item ->
                    TransactionItem(
                        name = if(item.sender.name == userName)
                            item.recipient.name else item.sender.name,
                        cardDetails = if(item.sender.name == userName)
                            "xxxx xxxx ${item.recipient.accountNumber.takeLast(4)}" else "xxxx xxxx ${item.sender.accountNumber.takeLast(4)}",
                        transactionTime = formatDate(item.createdAt),
                        transactionType = if(item.recipient.name == userName)
                            "Received" else "Sent",
                        amount = item.amount.toInt(),
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
    RecentTransactions(rememberNavController())
}