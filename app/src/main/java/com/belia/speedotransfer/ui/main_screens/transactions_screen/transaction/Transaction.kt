package com.belia.speedotransfer.ui.main_screens.transactions_screen.transaction

import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.common_ui.SpeedoNavigationBar
import com.belia.speedotransfer.ui.common_ui.TopBar
import com.belia.speedotransfer.ui.common_ui.TransferSection
import com.belia.speedotransfer.ui.theme.GrayG700
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.RedP300
import com.belia.speedotransfer.ui.theme.bodyMedium16
import com.belia.speedotransfer.ui.theme.bodyRegular16
import com.belia.speedotransfer.ui.theme.heading3
import com.belia.speedotransfer.util.formatDate
import com.belia.speedotransfer.viewmodels.SharedViewModel
import com.belia.speedotransfer.viewmodels.UserViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Transaction(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    index: Int,
    modifier: Modifier = Modifier,
    viewModel: UserViewModel = viewModel(),
) {
    val userId by sharedViewModel.userId.collectAsState()
    LaunchedEffect(userId) {
        viewModel.getUser(userId)
    }
    val user by viewModel.user.collectAsState()
    val transactions = user?.account?.transactions ?: emptyList()
    Log.d("trace", "Transaction: ${transactions.size}")
    if (transactions.isNotEmpty()){
        val transaction = transactions[index]
        Scaffold(
            topBar = {
                TopBar(color = Color(0xFFFFF8E7), navController = navController, hasIcon = true, title = "Successful Transactions")
            },
            bottomBar = {
                SpeedoNavigationBar(selectedIndex = 2, navController)
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
                Image(
                    painter = painterResource(id = R.drawable.ic_confirm),
                    contentDescription = "Confirm Icon",
                    modifier = modifier.padding(16.dp)
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(GrayG900)) {
                            append("${transaction.amount.toInt()} ")
                        }
                        withStyle(style = SpanStyle(RedP300)) {
                            append("EGP")
                        }
                    },
                    style = heading3,
                    color = GrayG900,
                    modifier = modifier.padding(4.dp)
                )
                Text(
                    text = "Transfer Amount",
                    style = bodyRegular16,
                    color = GrayG700,
                    modifier = modifier.padding(4.dp)
                )
                Text(
                    text =  if(transaction.recipientName == user.name)
                        "Received money" else "Sent money",
                    style = bodyMedium16,
                    color = RedP300,
                )
                Spacer(modifier = modifier.padding(8.dp))
                TransferSection(
                    fromName = transaction.senderName,
                    fromAccountNum = transaction.senderAccount,
                    toName = transaction.recipientName,
                    toAccountNum = transaction.recipientAccount,
                    image = R.drawable.ic_success,
                )
                TransferDetails(amount = transaction.amount, reference = "123456789876", date = formatDate(transaction.createdAt))
            }
        }
    }
    else {
        Log.d("trace", "Transaction: No transactions found")
    }
}

@Preview(showBackground = true)
@Composable
private fun TransactionPrev() {

}