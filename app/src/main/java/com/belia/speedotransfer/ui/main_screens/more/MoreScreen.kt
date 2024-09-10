package com.belia.speedotransfer.ui.main_screens.more

import android.content.Intent
import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.belia.speedotransfer.R
import com.belia.speedotransfer.navigation.AppRoutes.FAVOURITES
import com.belia.speedotransfer.ui.common_ui.SpeedoNavigationBar
import com.belia.speedotransfer.ui.common_ui.TopBar
import com.belia.speedotransfer.ui.theme.GrayG200
import com.belia.speedotransfer.ui.theme.GrayG40
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.RedP300
import com.belia.speedotransfer.ui.theme.bodyMedium16
import com.belia.speedotransfer.ui.theme.bodyRegular16

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var isBottomSheetVisible by remember { mutableStateOf(false) }
    var state = rememberModalBottomSheetState()

    Scaffold(
        topBar = {
            TopBar(color = Color(0xFFFFF8E7), navController = navController, title = "More", hasIcon = true)
        },
        bottomBar = {
            SpeedoNavigationBar(selectedIndex = 4, navController)
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding())
                .background(
                    brush = Brush.linearGradient(
                        listOf(Color(0xFFFFF8E7), Color(0xFFFFEAEE))
                    )
                )
        ) {
            MoreItem(icon = R.drawable.website, title = "Transfer From Website", hasSahm = true)
            HorizontalDivider(modifier = modifier.padding(horizontal = 16.dp), color = GrayG40)
            MoreItem(icon = R.drawable.favorite, title = "Favorites", hasSahm = true) {
                navController.navigate(FAVOURITES)
            }
            HorizontalDivider(modifier = modifier.padding(horizontal = 16.dp), color = GrayG40)
            MoreItem(icon = R.drawable.user, title = "Profile", hasSahm = true)
            HorizontalDivider(modifier = modifier.padding(horizontal = 16.dp), color = GrayG40)
            MoreItem(icon = R.drawable.ic_help, title = "Help", hasSahm = true) {
                isBottomSheetVisible = true
            }
            HorizontalDivider(modifier = modifier.padding(horizontal = 16.dp), color = GrayG40)
            MoreItem(icon = R.drawable.logout, title = "Logout")
        }
    }

    if (isBottomSheetVisible) {
        ModalBottomSheet(
            sheetState = state,
            content = {
                HelpBottomSheet()
            },
            onDismissRequest = { isBottomSheetVisible = false },
            containerColor = Color.White
        )
    }
}

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
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp,),
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


@Composable
fun MoreItem(
    @DrawableRes icon: Int,
    title: String,
    modifier: Modifier = Modifier,
    hasSahm: Boolean = false,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = title,
            tint = GrayG200,
            modifier = modifier.padding(end = 8.dp)
        )

        Text(
            text = title,
            style = bodyMedium16,
            color = GrayG200,
            modifier = Modifier.weight(1f)
        )
        if (hasSahm) {
            Icon(
                painter = painterResource(id = R.drawable.ic_more_sahm),
                contentDescription = "",
                tint = GrayG200
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Prevvv() {
    MoreScreen(navController = rememberNavController())
}