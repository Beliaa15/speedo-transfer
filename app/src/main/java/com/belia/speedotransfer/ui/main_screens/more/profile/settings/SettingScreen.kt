package com.belia.speedotransfer.ui.main_screens.more.profile.settings

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
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.belia.speedotransfer.R
import com.belia.speedotransfer.navigation.AppRoutes
import com.belia.speedotransfer.ui.common_ui.TopBar
import com.belia.speedotransfer.ui.theme.GrayG100
import com.belia.speedotransfer.ui.theme.GrayG200
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.bodyMedium16
import com.belia.speedotransfer.ui.theme.bodyRegular16

@Composable
fun SettingsScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { TopBar(color = Color(0xFFFFF8E7), navController = navController, title = "Settings", hasIcon = true) },
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
            Spacer(modifier = modifier.height(32.dp))
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(horizontal = 16.dp)
                    .clickable { navController.navigate(AppRoutes.CHANGEPASSWORD) },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_settings_circle),
                    contentDescription = "Change Password",
                    modifier = modifier.padding(end = 8.dp)
                )
                Spacer(modifier = modifier.padding(8.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Change Password",
                        style = bodyMedium16,
                        color = GrayG900,
                    )
                    Text(
                        text = "Change Your Password",
                        style = bodyRegular16,
                        color = GrayG100,
                    )
                }
                    Icon(
                        painter = painterResource(id = R.drawable.ic_more_sahm),
                        contentDescription = "",
                        tint = GrayG200
                    )

            }

            Spacer(modifier = modifier.height(16.dp))

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(horizontal = 16.dp)
                    .clickable { navController.navigate(AppRoutes.EDITPROFILE) },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_edit_circle2),
                    contentDescription = "Change Password",
                    modifier = modifier.padding(end = 8.dp)
                )

                Spacer(modifier = modifier.padding(8.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Edit Profile",
                        style = bodyMedium16,
                        color = GrayG900,
                    )
                    Text(
                        text = "Change Your information",
                        style = bodyRegular16,
                        color = GrayG100,
                    )
                }

                Icon(
                    painter = painterResource(id = R.drawable.ic_more_sahm),
                    contentDescription = "",
                    tint = GrayG200
                )

            }

        }
    }
}

@Preview
@Composable
private fun Prevvvvvvvvv() {
    SettingsScreen(navController = rememberNavController())
}