package com.belia.speedotransfer.ui.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.theme.GrayG100
import com.belia.speedotransfer.ui.theme.GrayG700
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.RedP300
import com.belia.speedotransfer.ui.theme.RedP50
import com.belia.speedotransfer.ui.theme.bodyMedium14
import com.belia.speedotransfer.ui.theme.bodyMedium16
import com.belia.speedotransfer.ui.theme.bodyRegular14

@Composable
fun TransactionItem(
    name: String,
    cardDetails: String,
    transactionTime: String,
    transactionType: String,
    amount: Int,
    cardIcon: Int,
    modifier: Modifier = Modifier
) {
    Box {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
                .padding(top = 4.dp)
        ) {
            Box(
                modifier = modifier
                    .size(64.dp)
                    .background(
                        color = RedP50,
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = cardIcon),
                    contentDescription = "Card Icon",
                    modifier = modifier
                        .size(32.dp)
                )
            }
            Spacer(modifier = modifier.width(16.dp))

            Column(
                horizontalAlignment = Alignment.Start,
                modifier = modifier
                    .weight(1f)
                    .wrapContentHeight()
            ) {
                Text(
                    text = name,
                    color = GrayG900,
                    style = bodyMedium14,
                    modifier = modifier.padding(vertical = 2.dp)
                )
                Text(
                    text = cardDetails,
                    color = GrayG700,
                    style = bodyRegular14,
                    modifier = modifier.padding(bottom = 2.dp)
                )
                Text(
                    text = "$transactionTime - $transactionType",
                    color = GrayG100,
                    style = bodyRegular14
                )
            }

            Text(
                text = "${amount}EGP",
                color = RedP300,
                style = bodyMedium16,
                modifier = modifier
                    .padding(4.dp)
                    .align(Alignment.Top)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TransactionItemPreview() {
    TransactionItem(
        name = "Ahmed Mohamed",
        cardDetails = "Visa . Master Card . 1234",
        transactionTime = "Today 11:00",
        transactionType = "Received",
        amount = 500,
        cardIcon = R.drawable.mastercard_logo
    )
}