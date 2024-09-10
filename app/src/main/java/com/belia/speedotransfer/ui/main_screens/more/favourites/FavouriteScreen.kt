package com.belia.speedotransfer.ui.main_screens.more.favourites


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.belia.speedotransfer.ui.common_ui.SpeedoNavigationBar
import com.belia.speedotransfer.ui.common_ui.TopBar
import com.belia.speedotransfer.ui.theme.titleSemiBold

@Composable
fun FavouriteScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopBar(color = Color(0xFFFFF8E7), navController, title = "Favourites", hasIcon = true)
        },
        bottomBar = {
            SpeedoNavigationBar(selectedIndex = 4, navController)
        },
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding())
                .background(
                    brush = Brush.linearGradient(
                        listOf(Color(0xFFFFF8E7), Color(0xFFFFEAEE))
                    )
                )
                .verticalScroll(rememberScrollState())
                .imePadding(),
        ) {
            Text(
                text = "Your Favourites List",
                style = titleSemiBold,
                modifier = modifier.padding(top = 20.dp, bottom = 16.dp),
            )

            //TODO("Add favourite list from API")

            FavouriteItem(account = "Belia", name = "Belia")
            FavouriteItem(account = "Belia", name = "Belia")
            FavouriteItem(account = "Belia", name = "Belia")
            FavouriteItem(account = "Belia", name = "Belia")

        }
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun FavouriteItemPreview() {
    //FavouriteItem(account = "a2s1d32as1321asd", name = "asdasdasd")
    FavouriteScreen(rememberNavController())
//    EditTextField(title = "asdasd", placeholder = "asdasd"){ }
    //FavouriteBottomSheet()
}