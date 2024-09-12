package com.belia.speedotransfer.ui.main_screens.more

import android.content.Intent
import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.belia.speedotransfer.R
import com.belia.speedotransfer.navigation.AppRoutes
import com.belia.speedotransfer.navigation.AppRoutes.FAVOURITES
import com.belia.speedotransfer.navigation.AppRoutes.PROFILE
import com.belia.speedotransfer.ui.common_ui.SpeedoNavigationBar
import com.belia.speedotransfer.ui.common_ui.TopBar
import com.belia.speedotransfer.ui.main_screens.more.help.HelpBottomSheet
import com.belia.speedotransfer.ui.theme.GrayG200
import com.belia.speedotransfer.ui.theme.GrayG40
import com.belia.speedotransfer.ui.theme.bodyMedium16
import com.belia.speedotransfer.viewmodels.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = viewModel()
) {
    var isBottomSheetVisible by remember { mutableStateOf(false) }
    var state = rememberModalBottomSheetState()
    var context = LocalContext.current

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
            MoreItem(icon = R.drawable.website, title = "Transfer From Website", hasSahm = true){
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
                context.startActivity(intent)
            }
            HorizontalDivider(modifier = modifier.padding(horizontal = 16.dp), color = GrayG40)
            MoreItem(icon = R.drawable.favorite, title = "Favorites", hasSahm = true) {
                navController.navigate(FAVOURITES)
            }
            HorizontalDivider(modifier = modifier.padding(horizontal = 16.dp), color = GrayG40)
            MoreItem(icon = R.drawable.user, title = "Profile", hasSahm = true){
                navController.navigate(PROFILE)
            }
            HorizontalDivider(modifier = modifier.padding(horizontal = 16.dp), color = GrayG40)
            MoreItem(icon = R.drawable.ic_help, title = "Help", hasSahm = true) {
                isBottomSheetVisible = true
            }
            HorizontalDivider(modifier = modifier.padding(horizontal = 16.dp), color = GrayG40)
            MoreItem(icon = R.drawable.logout, title = "Logout"){
                viewModel.logoutUser()
                navController.navigate(AppRoutes.LOGIN){
                    popUpTo(AppRoutes.LOGIN) {
                        inclusive = true
                    }
                }
            }
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