package com.belia.speedotransfer.ui.common_ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.belia.speedotransfer.R

@Composable
fun TransferSection(
    fromName: String,
    fromAccountNum: String,
    toName: String,
    toAccountNum: String,
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy((-24).dp)
    ) {
        TransferCard(type = "From", name = fromName, accountNum = fromAccountNum)
        Image(
            painter = painterResource(id = image),
            contentDescription = "Transfer Icon",
            modifier = modifier
                .size(44.dp)
                .zIndex(1f)
        )
        TransferCard(type = "To", name = toName, accountNum = toAccountNum)
    }
}

@Preview
@Composable
private fun TransferSectionPrev() {
    TransferSection("Asmaa Dosuky", "xxxx7890", "Asmaa Dosuky", "xxxx7890", R.drawable.ic_success)
}