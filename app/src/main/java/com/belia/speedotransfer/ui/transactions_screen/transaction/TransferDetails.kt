package com.belia.speedotransfer.ui.transactions_screen.transaction

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belia.speedotransfer.ui.common_ui.TotalAmount
import com.belia.speedotransfer.ui.theme.GrayG100
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.RedP50
import com.belia.speedotransfer.ui.theme.bodyRegular16

@Composable
fun TransferDetails(
    amount: Float,
    reference: String,
    date: String,
    time: String,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = RedP50,
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column {
            TotalAmount(amount = amount)
            Spacer(modifier = modifier.padding(4.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ){
                Text(
                    text = "Reference",
                    style = bodyRegular16,
                    color = GrayG900
                )
                Text(
                    text = reference,
                    style = bodyRegular16,
                    color = GrayG100,
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ){
                Text(
                    text = "Date",
                    style = bodyRegular16,
                    color = GrayG900
                )
                Row {
                    Text(
                        text = "$date $time",
                        style = bodyRegular16,
                        color = GrayG100,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TransferDetailsPrev() {
    TransferDetails(1000f, "123456789876", "20 Jul 2024", "7:50")
}