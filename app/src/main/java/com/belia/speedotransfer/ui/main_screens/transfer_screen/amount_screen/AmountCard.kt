package com.belia.speedotransfer.ui.main_screens.transfer_screen.amount_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belia.speedotransfer.ui.theme.GrayG0
import com.belia.speedotransfer.ui.theme.GrayG100
import com.belia.speedotransfer.ui.theme.GrayG70
import com.belia.speedotransfer.ui.theme.GrayG700
import com.belia.speedotransfer.ui.theme.bodyRegular16
import com.belia.speedotransfer.ui.theme.titleSemiBold

@Composable
fun AmountCard(
    amount: String,
    onAmountChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = GrayG0
        )
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
                .padding(vertical = 16.dp, horizontal = 8.dp)
        ) {
            Text(
                text = "Amount",
                style = bodyRegular16
            )
            OutlinedTextField(
                value = amount,
                onValueChange = onAmountChange,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                shape = RoundedCornerShape(8.dp),
                placeholder = {
                    Text(
                        text = "Enter Amount",
                        color = GrayG70
                    )
                },
                singleLine = true,
                textStyle = titleSemiBold,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = GrayG100,
                    focusedBorderColor = GrayG100,
                    cursorColor = GrayG700
                )
            )

        }
    }
}

@Preview(showBackground = false)
@Composable
private fun AmountCardPrev() {
    AmountCard("", {})
}