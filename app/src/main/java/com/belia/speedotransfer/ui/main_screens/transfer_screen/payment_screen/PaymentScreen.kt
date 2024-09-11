package com.belia.speedotransfer.ui.main_screens.transfer_screen.payment_screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.belia.speedotransfer.navigation.AppRoutes.HOME
import com.belia.speedotransfer.ui.common_ui.EmptyButton
import com.belia.speedotransfer.ui.common_ui.RedButton
import com.belia.speedotransfer.ui.common_ui.SpeedoNavigationBar
import com.belia.speedotransfer.ui.common_ui.StepProgressIndicator
import com.belia.speedotransfer.ui.common_ui.TopBar
import com.belia.speedotransfer.ui.common_ui.TotalAmount
import com.belia.speedotransfer.ui.common_ui.TransferSection
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.titleSemiBold
import com.belia.speedotransfer.viewmodels.SharedViewModel
import com.belia.speedotransfer.viewmodels.UserViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.belia.speedotransfer.navigation.AppRoutes
import com.belia.speedotransfer.viewmodels.FavouritesViewModel

@Composable
fun PaymentScreen(
    amount: Float,
    name: String,
    account: String,
    navController: NavController,
    sharedViewModel: SharedViewModel,
    modifier: Modifier = Modifier,
    viewModel: UserViewModel = viewModel(),
    favouritesViewModel: FavouritesViewModel = viewModel()
) {
    val userId by sharedViewModel.userId.collectAsState()
    viewModel.getUser(userId)
    val user by viewModel.user.collectAsState()
    val myAccount = user.account
    val context = LocalContext.current

    Scaffold (
        topBar = {
            TopBar(color = Color(0xFFFFF8E7), navController = navController ,hasIcon = true, title = "Transfer")
        },
        bottomBar = {
            SpeedoNavigationBar(selectedIndex = 1, navController)
        }
    ) {
            innerPadding ->
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFFFF8E7), Color(0xFFFFEAEE)),
                    )
                )
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            StepProgressIndicator(currentStep = 3)
            Image(painter = painterResource(
                id = R.drawable.ic_confirmation),
                contentDescription = "Hello",
                modifier = modifier.padding(8.dp)
            )
            Text(
                text = "Your transfer was successful",
                style = titleSemiBold,
                color = GrayG900,
                modifier = modifier.padding(8.dp)
            )
            TransferSection(
                fromName = "Asmaa Dosuky",
                fromAccountNum = "xxxx7890",
                toName = name,
                toAccountNum = account,
                image = R.drawable.ic_success
            )
            Spacer(modifier = Modifier.padding(4.dp))
            TotalAmount(amount = amount)
            RedButton(
                text = "Back to Home",
                onClick = {
                    navController.navigate(route = HOME){
                        popUpTo(AppRoutes.HOME) {
                            inclusive = true
                        }
                    }
                    // TODO: Pop back stack to home screen
                },
                modifier = modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = modifier.padding(8.dp))
            EmptyButton(
                text = "Add to Favourites",
                onClick = {
                    favouritesViewModel.createFavourite(myAccount.accountNumber, name, account)
                    Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show()
                    navController.navigate(route = HOME){
                        popUpTo(AppRoutes.HOME) {
                            inclusive = true
                        }
                    }
                },
                modifier = modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = modifier.padding(16.dp))
        }
    }
}

@Preview
@Composable
private fun PaymentScreenPrev() {
    //PaymentScreen(amount = 1000f, "Jonathan Smith", "xxxx7890", navController = rememberNavController())
}