package com.belia.speedotransfer.ui.transactions_screen.last_transcations

import android.view.SurfaceControl.Transaction
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.theme.DangerD300
import com.belia.speedotransfer.ui.theme.GrayG0
import com.belia.speedotransfer.ui.theme.GrayG100
import com.belia.speedotransfer.ui.theme.GrayG200
import com.belia.speedotransfer.ui.theme.GrayG700
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.InterFontFamily
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
    transactionDate: String,
    transactionType: String,
    transactionAmount: String,
    transactionStatus: String,
    modifier: Modifier = Modifier
) {
    Box (
        modifier = modifier
            .background(
                color = GrayG0,
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                width = 1.dp,
                color = RedP50,
                shape = RoundedCornerShape(8.dp)
            )
            //.padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
                .padding(top = 4.dp)
        ) {
            Box(
                modifier = modifier
                    .size(55.dp)
                    .background(
                        color = RedP50,
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = if(transactionStatus == "Successful")
                                painterResource(id = R.drawable.ic_card)
                            else
                                painterResource(id = R.drawable.ic_bank),
                    contentDescription = "Card Icon",
                    colorFilter = ColorFilter.tint(RedP300),
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
                    text = "$transactionDate $transactionTime - $transactionType",
                    color = GrayG100,
                    style = bodyRegular14
                )

                Text(
                    text = "$$transactionAmount",
                    color = RedP300,
                    style = bodyMedium16,
                    modifier = modifier
                        .padding(vertical = 16.dp)
                )
            }

            Column (
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.End
            ) {
                IconButton(
                    onClick = { /*TODO*/ },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "forward button",
                        tint = GrayG200,
                        modifier = modifier
                            .size(24.dp)
                            .rotate(180f)
                    )
                }
                Text(
                    text = transactionStatus,
                    color = if (transactionStatus == "Successful")
                                Color(0xFF118A30)
                            else
                                DangerD300,
                    fontFamily = InterFontFamily,
                    fontSize = 10.sp,
                    //lineHeight = 14.dp,
                    modifier = if (transactionStatus == "Successful") {
                        Modifier
                            .background(Color(0xFFEAF3EC), shape = RoundedCornerShape(4.dp))
                            .padding(horizontal = 8.dp, vertical = 5.dp)
                    } else {
                        Modifier
                            .background(Color(0xFFFFEFEF), shape = RoundedCornerShape(4.dp))
                            .padding(horizontal = 8.dp, vertical = 5.dp)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
private fun TransactionItemPrev() {
    TransactionItem(
        name = "Ahmed Mohamed",
        cardDetails = "Visa . Master Card . 1234",
        transactionTime = "10:00",
        transactionDate = "Today",
        transactionType = "Received",
        transactionAmount = "1000",
        transactionStatus = "Successful",
    )
}