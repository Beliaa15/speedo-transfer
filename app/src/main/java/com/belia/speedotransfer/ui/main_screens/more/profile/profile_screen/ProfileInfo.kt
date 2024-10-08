package com.belia.speedotransfer.ui.main_screens.more.profile.profile_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.belia.speedotransfer.ui.common_ui.SpeedoNavigationBar
import com.belia.speedotransfer.ui.common_ui.TopBar
import com.belia.speedotransfer.ui.theme.GrayG100
import com.belia.speedotransfer.ui.theme.GrayG40
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.bodyMedium16
import com.belia.speedotransfer.ui.theme.bodyRegular16
import com.belia.speedotransfer.viewmodels.SharedViewModel
import com.belia.speedotransfer.viewmodels.UserViewModel

@Composable
fun ProfileInfo(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    modifier: Modifier = Modifier,
    viewModel: UserViewModel = viewModel(),
) {
    val userId by sharedViewModel.userId.collectAsState()
    viewModel.getUser(userId)
    val user by viewModel.user.collectAsState()
    val name = user.name
    val email = user.email
    val dob = user.dob
    val country = user.country
    val account = user.account.accountNumber
    Scaffold(
        topBar = {
            TopBar(color = Color(0xFFFFF8E7), navController, title = "Profile Information", hasIcon = true)
        },
        bottomBar = {
            SpeedoNavigationBar(selectedIndex = 4, navController = rememberNavController())
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
            Spacer(modifier = modifier.padding(12.dp))
            InfoCard(
                title = "Full Name",
                subtitle = name
            )
            InfoCard(
                title = "Email",
                subtitle = email
            )
            InfoCard(
                title = "Date of Birth",
                subtitle = dob
            )
            InfoCard(
                title = "Country",
                subtitle = country
            )
            InfoCard(
                title = "Bank Account",
                subtitle = account
            )
//            HorizontalDivider(
//                color = GrayG40,
//                modifier = modifier.padding(horizontal = 16.dp)
//            )
        }
    }
}

@Composable
fun InfoCard(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Column(
                modifier = modifier.padding(vertical = 16.dp)
            ) {
                Text(
                    text = title,
                    style = bodyMedium16,
                    color = GrayG900
                )
                Spacer(modifier = modifier.padding(8.dp))
                Text(
                    text = subtitle,
                    style = bodyRegular16,
                    color = GrayG100
                )
            }
        }
        HorizontalDivider(
            color = GrayG40,
            modifier = modifier.padding(horizontal = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileInfoPrev() {
//    ProfileInfo(
//
//        rememberNavController()
//    )
//    InfoCard(
//        title = "Full Name",
//        subtitle = "Mohaned Emad"
//    )
}