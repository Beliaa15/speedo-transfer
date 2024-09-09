package com.belia.speedotransfer.ui.errors


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.common_ui.EmptyButton
import com.belia.speedotransfer.ui.common_ui.RedButton
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.bodyRegular16
import com.belia.speedotransfer.ui.theme.heading3


@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFFFF8E7), Color(0xFFFFEAEE)),
                )
            )
            .padding(vertical = 36.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.cuate),
            contentDescription = "ServerError",
            modifier = Modifier.size(270.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Server error...",
            style = heading3,
            color = GrayG900,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "It seems like we’re haveing some diffculities , please don’t leave your aspirations, we are sending for help",
            style = bodyRegular16,
            textAlign = TextAlign.Center,
            modifier = modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        RedButton(text = "Call Us", onClick = { /*TODO*/ })
        Spacer(modifier = modifier.height(12.dp))
        EmptyButton(text = "Message Us", onClick = { /*TODO*/ })
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun prevvv() {
    ErrorScreen()
}
