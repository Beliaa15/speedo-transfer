package com.belia.speedotransfer.ui.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.belia.speedotransfer.ui.theme.bodyMedium16
import com.belia.speedotransfer.ui.theme.bodyRegular14
import com.belia.speedotransfer.ui.theme.titleSemiBold

@Composable
fun TopSection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = modifier
                    .size(48.dp)
                    .background(
                        color = GrayG40,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "AD",
                    color = GrayG100,
                    modifier = modifier.padding(4.dp),
                    style = titleSemiBold
                )
            }
            Spacer(modifier = modifier.width(8.dp))
            Column {
                Text(
                    text = "Welcome back,",
                    color = RedP300,
                    style = bodyRegular14
                )
                Spacer(modifier = modifier.height(4.dp))
                Text(
                    text = "Asmaa Dosuky",
                    style = bodyMedium16,
                    color = GrayG900
                )
            }
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(painter = painterResource(
                id = R.drawable.ic_notification),
                contentDescription = "Notification icon",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TopSectionPrev() {
    TopSection()
}