package com.belia.speedotransfer.ui.main_screens.more.help

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.RedP300
import com.belia.speedotransfer.ui.theme.bodyMedium16
import com.belia.speedotransfer.ui.theme.bodyRegular16

@Composable
fun HelpBottomSheet(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Spacer(modifier = modifier.height(56.dp))
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 51.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 3.dp
            ),
            onClick = {
                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:support@example.com")
                    putExtra(Intent.EXTRA_EMAIL, arrayOf("support@example.com"))
                    putExtra(Intent.EXTRA_SUBJECT, "Support Request")
                    putExtra(Intent.EXTRA_TEXT, "I need help with...")
                }
                context.startActivity(Intent.createChooser(emailIntent, "Send Email"))
            },
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            modifier = modifier
                .size(120.dp, 140.dp)
        ) {
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.email_square),
                    contentDescription = "",
                )
                Spacer(modifier = modifier.height(16.dp))
                Text(
                    text = "Send Email",
                    style = bodyMedium16,
                    color = GrayG900,
                    modifier = modifier.padding(bottom = 16.dp)
                )
            }
        }
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
            onClick = {
                val callIntent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:000000")
                }
                context.startActivity(callIntent)
            },
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            modifier = modifier
                .size(120.dp, 140.dp)
        ) {
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.callus_square),
                    contentDescription = "",
                )
                Spacer(modifier = modifier.height(16.dp))
                Text(text = "Call Us", style = bodyMedium16, color = GrayG900)
                Text(text = "000000", style = bodyRegular16, color = RedP300)
            }
        }
    }
    Spacer(modifier = modifier.height(56.dp))
}
