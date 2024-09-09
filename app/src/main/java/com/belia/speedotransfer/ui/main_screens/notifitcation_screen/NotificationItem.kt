package com.belia.speedotransfer.ui.main_screens.notifitcation_screen

import android.app.Notification
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.theme.GrayG0
import com.belia.speedotransfer.ui.theme.GrayG100
import com.belia.speedotransfer.ui.theme.GrayG700
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.RedP300
import com.belia.speedotransfer.ui.theme.RedP50
import com.belia.speedotransfer.ui.theme.bodyMedium16
import com.belia.speedotransfer.ui.theme.bodyRegular12
import com.belia.speedotransfer.ui.theme.bodyRegular14

@Composable
fun NotificationItem(
    type: String,
    amount: Float,
    name: String,
    account: String,
    date: String,
    time: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        //elevation = 4.dp,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = RedP50
        )
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp, horizontal = 8.dp)
        ) {
            Box(
                modifier = modifier
                    .size(55.dp)
                    .background(
                        color = Color(0xFFf3e9eb),
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center

            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_notification),
                    contentDescription = "Card Icon",
                    //colorFilter = ColorFilter.tint(RedP300),
                    modifier = modifier
                        .size(32.dp)
                )
            }
            Column (
                modifier = modifier.padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "$type transaction",
                    color = GrayG900,
                    style = bodyMedium16
                )
                Spacer(modifier = modifier.size(4.dp))
                Text(
                    text = "You have $type ${amount.toInt()} EGP from $name $account",
                    color = GrayG700,
                    style = bodyRegular14
                )
                Spacer(modifier = modifier.size(4.dp))
                Text(
                    text = "$date $time",
                    color = GrayG100,
                    style = bodyRegular12
                )
            }
        }
    }
}

@Preview
@Composable
private fun NotificationItemPrev() {
    NotificationItem(
        type = "Received",
        amount = 1000f,
        name = "John Doe",
        account = "1234 xxx",
        date = "28 Jul 2024",
        time = "09:00 AM"
    )
}