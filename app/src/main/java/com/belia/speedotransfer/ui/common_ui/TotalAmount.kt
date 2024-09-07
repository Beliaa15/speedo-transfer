package com.belia.speedotransfer.ui.common_ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belia.speedotransfer.ui.theme.GrayG40
import com.belia.speedotransfer.ui.theme.GrayG500
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.bodyMedium16
import com.belia.speedotransfer.ui.theme.bodyRegular16

@Composable
fun TotalAmount(
    amount: Float,
    modifier: Modifier = Modifier
) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Total amount",
                style = bodyMedium16,
                color = GrayG900
            )
            Text(
                text = "${amount.toInt()} EGP",
                style = bodyRegular16,
                color = GrayG500
            )
        }
        HorizontalDivider(
            thickness = 1.dp,
            color = GrayG40,
            modifier = modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TotalAmountPrev() {
    TotalAmount(amount = 1000f)
}