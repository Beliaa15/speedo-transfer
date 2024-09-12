package com.belia.speedotransfer.ui.main_screens.transfer_screen.confirmation_screen

import android.util.Log
import android.widget.Toast
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.belia.speedotransfer.R
import com.belia.speedotransfer.navigation.AppRoutes
import com.belia.speedotransfer.navigation.AppRoutes.PAYMENT
import com.belia.speedotransfer.ui.common_ui.EmptyButton
import com.belia.speedotransfer.ui.common_ui.RedButton
import com.belia.speedotransfer.ui.common_ui.SpeedoNavigationBar
import com.belia.speedotransfer.ui.common_ui.StepProgressIndicator
import com.belia.speedotransfer.ui.common_ui.TopBar
import com.belia.speedotransfer.ui.common_ui.TotalAmount
import com.belia.speedotransfer.ui.common_ui.TransferSection
import com.belia.speedotransfer.ui.theme.GrayG500
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.bodyRegular16
import com.belia.speedotransfer.ui.theme.titleSemiBold
import com.belia.speedotransfer.util.HandleErrors
import com.belia.speedotransfer.util.sendNotification
import com.belia.speedotransfer.viewmodels.SharedViewModel
import com.belia.speedotransfer.viewmodels.TransferViewModel
import com.belia.speedotransfer.viewmodels.UserViewModel
import java.math.BigDecimal

@Composable
fun ConfirmationScreen(
    amount: Float,
    name: String,
    account: String,
    navController: NavController,
    sharedViewModel: SharedViewModel,
    modifier: Modifier = Modifier,
    viewModel: TransferViewModel = viewModel(),
    userViewModel: UserViewModel = viewModel()
) {
    val userId by sharedViewModel.userId.collectAsState()
    userViewModel.getUser(userId)
    val context = LocalContext.current
    val user by userViewModel.user.collectAsState()
    val currentBalance = user.account.balance
    val userAccount = user.account.accountNumber
    viewModel.amount = BigDecimal(amount.toString())
    val notFound by viewModel.notFound.collectAsState()
    val internet by viewModel.networkError.collectAsState()

    HandleErrors(viewModel = viewModel, onRetry = {
        navController.navigate(AppRoutes.LOGIN) {
            popUpTo(AppRoutes.LOGIN) {
                inclusive = true
            }
        }
    }) {
        Scaffold(
            topBar = {
                TopBar(color = Color(0xFFFFF8E7), navController, hasIcon = true, title = "Transfer")
            },
            bottomBar = {
                SpeedoNavigationBar(selectedIndex = 1, navController)
            }
        ) { innerPadding ->
            Column(
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
                StepProgressIndicator(currentStep = 2)
                Spacer(modifier = modifier.padding(12.dp))
                Text(
                    text = "${amount.toInt()} EGP",
                    style = titleSemiBold,
                    color = GrayG900,
                    modifier = modifier.padding(8.dp)
                )
                Text(
                    text = "Transfer amount",
                    style = bodyRegular16,
                    color = GrayG500,
                    modifier = modifier.padding(4.dp)
                )
                TotalAmount(amount = amount)

                TransferSection(
                    fromName = user.name,
                    fromAccountNum = "xxxx xxxx ${userAccount.takeLast(4)}",
                    toName = name,
                    toAccountNum = "xxxx xxxx ${account.takeLast(4)}",
                    image = R.drawable.ic_transfer
                )

                RedButton(
                    text = "Confirm",
                    onClick = {
                        if (notFound) {
                            Toast.makeText(context, "User not found", Toast.LENGTH_SHORT).show()
                        } else {
                            if(!internet) {
                                if (currentBalance >= amount) {
                                    viewModel.transfer(userAccount, account)
                                    sendNotification(
                                        title = "Successful Transaction",
                                        text = "You have successfully sent $amount to $name",
                                        context = context
                                    )
                                    navController.navigate("$PAYMENT/$amount/$name/$account")
                                } else {
                                    Toast.makeText(
                                        context,
                                        "Insufficient Balance",
                                        Toast.LENGTH_SHORT
                                    )
                                        .show()
                                }
                            }
                        }
                    },
                    modifier = modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = modifier.padding(8.dp))
                EmptyButton(
                    text = "Previous",
                    onClick = {
                        navController.popBackStack()
                    },
                    modifier = modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun TransferScreenPreview() {
    //ConfirmationScreen(amount = 1000f, "Jonathan Smith", "xxxx7890", rememberNavController())
}