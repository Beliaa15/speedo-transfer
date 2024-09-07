package com.belia.speedotransfer.ui.common_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import com.belia.speedotransfer.ui.theme.GrayG40
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.RedP300
import com.belia.speedotransfer.ui.theme.RedP50
import com.belia.speedotransfer.ui.theme.bodyMedium16
import com.belia.speedotransfer.ui.theme.bodyRegular16
import com.belia.speedotransfer.ui.theme.titleSemiBold

@Composable
fun TransferCard(
    type: String,
    name: String,
    accountNum: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(color = RedP50, shape = RoundedCornerShape(8.dp))
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(16.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .size(48.dp)
                    .background(
                        color = GrayG40,
                        shape = CircleShape
                    )
            ) {
                Image(painter = painterResource(id = R.drawable.ic_bank),
                    contentDescription = "Bank Icon",
                    modifier = modifier.size(32.dp),
                )
            }
            Column (
                modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = type,
                    style = bodyMedium16,
                    color = RedP300,
                    modifier = modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = name,
                    style = titleSemiBold,
                    color = GrayG900,
                    modifier = modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Account $accountNum",
                    style = bodyRegular16,
                    color = GrayG100,
                )
            }
        }
    }
}

@Preview
@Composable
private fun TransferCardPrev() {
    TransferCard(
        type = "From",
        name = "Asmaa Dosuky",
        accountNum = "xxxx7890"
    )
}