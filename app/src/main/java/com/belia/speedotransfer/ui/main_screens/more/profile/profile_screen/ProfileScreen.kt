package com.belia.speedotransfer.ui.main_screens.more.profile.profile_screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.common_ui.SpeedoNavigationBar
import com.belia.speedotransfer.ui.common_ui.TopBar
import com.belia.speedotransfer.ui.theme.GrayG100
import com.belia.speedotransfer.ui.theme.GrayG200
import com.belia.speedotransfer.ui.theme.GrayG40
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.RedP300
import com.belia.speedotransfer.ui.theme.RedP50
import com.belia.speedotransfer.ui.theme.bodyMedium16
import com.belia.speedotransfer.ui.theme.bodyRegular16
import com.belia.speedotransfer.ui.theme.titleSemiBold

@Composable
fun ProfileScreen(
    name: String,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopBar(color = Color(0xFFFFF8E7), navController, title = "Profile", hasIcon = true)
        },
        bottomBar = {
            SpeedoNavigationBar(selectedIndex = 4, navController)
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(top = innerPadding.calculateTopPadding())
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFFFF8E7), Color(0xFFFFEAEE)),
                    )
                )
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
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
                        text = getInitials(name),
                        color = GrayG100,
                        modifier = modifier.padding(4.dp),
                        style = titleSemiBold
                    )
                }
                Spacer(modifier = modifier.size(16.dp))
                Text(
                    text = name,
                    style = titleSemiBold,
                    color = GrayG900
                )
            }
            Spacer(modifier = modifier.size(8.dp))
            CardScreen(
                title = "Personal Information",
                subtitle = "Your information",
                icon = R.drawable.ic_user,
                onClick = { /*TODO*/ }
            )
            HorizontalDivider(
                color = GrayG40,
                modifier = modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            )
            CardScreen(
                title = "Settings",
                subtitle = "Change your settings",
                icon = R.drawable.ic_settings,
                onClick = { /*TODO*/ }
            )
            HorizontalDivider(
                color = GrayG40,
                modifier = modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            )
            CardScreen(
                title = "Payment History",
                subtitle = "View your transactions",
                icon = R.drawable.ic_history,
                onClick = { /*TODO*/ }
            )
            HorizontalDivider(
                color = GrayG40,
                modifier = modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            )
            CardScreen(
                title = "My Favourites list",
                subtitle = "View your favourites",
                icon = R.drawable.ic_favorite,
                onClick = { /*TODO*/ }
            )
        }
    }
}

@Composable
fun CardScreen(
    title: String,
    subtitle: String,
    @DrawableRes icon: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row  (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            //.padding(16.dp)
            .clickable { onClick }
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(16.dp)
        ) {
            Box(
                modifier = modifier
                    .size(48.dp)
                    .background(
                        color = RedP50,
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "$title icon",
                    tint = RedP300,
                    modifier = modifier
                        .size(24.dp)
                )
            }
            Spacer(modifier = modifier.size(16.dp))
            Column {
                Text(
                    text = title,
                    style = bodyMedium16,
                    color = GrayG900
                )
                Spacer(modifier = modifier.padding(2.dp))
                Text(
                    text = subtitle,
                    style = bodyRegular16,
                    color = GrayG100
                )
            }
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = "Forward Icon",
            tint = GrayG200,
            modifier = modifier
                .padding(horizontal = 16.dp)
                .rotate(180f)
        )
    }
}

fun getInitials(name: String): String {
    val words = name.split(" ")
    val initials = words.take(2).mapNotNull { it.firstOrNull()?.toString()?.uppercase() }
    return initials.joinToString("")
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenPrev() {
    ProfileScreen(name = "Asmaa Dosuky", rememberNavController())
//    CardScreen(
//        title = "Personal Information",
//        subtitle = "Your information",
//        icon = R.drawable.ic_user,
//        onClick = { /*TODO*/ })
}