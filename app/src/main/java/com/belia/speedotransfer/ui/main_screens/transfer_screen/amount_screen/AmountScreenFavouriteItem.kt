package com.belia.speedotransfer.ui.main_screens.transfer_screen.amount_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.theme.GrayG100
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.RedP50
import com.belia.speedotransfer.ui.theme.bodyMedium16
import com.belia.speedotransfer.ui.theme.bodyRegular16

@Composable
fun ASFavouriteItem(
    account: String,
    name: String,
    onClick: (List<String>) -> Unit,
    modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(100.dp)
            .clickable { onClick(listOf(name, account)) },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = RedP50)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxSize()
                .background(color = RedP50)
                .padding(start = 16.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.circle_favourite),
                contentDescription = "Favourite Contact",
                modifier = modifier.padding()
            )
            Column(
                modifier = modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            ) {
                Text(text = name, style = bodyMedium16, color = GrayG900)
                Spacer(modifier = modifier.height(8.dp))
                Text(text = account, style = bodyRegular16, color = GrayG100)
            }
        }
    }
}
