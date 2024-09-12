package com.belia.speedotransfer.ui.main_screens.more.favourites


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.belia.speedotransfer.ui.common_ui.SpeedoNavigationBar
import com.belia.speedotransfer.ui.common_ui.TopBar
import com.belia.speedotransfer.ui.theme.titleSemiBold
import com.belia.speedotransfer.viewmodels.FavouritesViewModel
import com.belia.speedotransfer.viewmodels.SharedViewModel

@Composable
fun FavouriteScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    modifier: Modifier = Modifier,
    viewModel: FavouritesViewModel = viewModel(),
) {
    val userId by sharedViewModel.userId.collectAsState()
    viewModel.getFavourites(userId)
    val favourites by viewModel.favourite.collectAsState()
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
        ) {
            Text(
                text = "Your Favourites List",
                style = titleSemiBold,
                modifier = modifier.padding(top = 20.dp, bottom = 16.dp),
            )
            LazyColumn{
                items(favourites) { item ->
                    FavouriteItem(account = item.recipientAccount, name = item.recipientName, sharedViewModel,)
                }
            }
        }
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun FavouriteItemPreview() {
    //FavouriteItem(account = "a2s1d32as1321asd", name = "asdasdasd")
    //FavouriteScreen(rememberNavController())
//    EditTextField(title = "asdasd", placeholder = "asdasd"){ }
    //FavouriteBottomSheet()
}