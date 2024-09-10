package com.belia.speedotransfer.ui.main_screens.transactions_screen.transaction

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

@Composable
fun Transaction(
    amount: Float,
    name: String,
    accountNum: String,
    transactionType: String,
    transactionDate: String,
    transactionTime: String,
    transactionStatus: String,
    reference: String,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopBar(color = Color(0xFFFFF8E7), navController = navController, hasIcon = true, title = "$transactionStatus Transactions")
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
                        append("${amount.toInt()} ")
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
                text = "$transactionType money",
                style = bodyMedium16,
                color = RedP300,
            )
            Spacer(modifier = modifier.padding(8.dp))
            TransferSection(
                fromName = "Asmaa Desouky",
                fromAccountNum = "xxxx7890",
                toName = name,
                toAccountNum = accountNum,
                image = R.drawable.ic_success,
            )
            TransferDetails(amount = amount, reference = reference, date = transactionDate, time = transactionTime)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TransactionPrev() {
    Transaction(
        amount = 1000f,
        name = "Jonathan Smith",
        accountNum = "xxxx7890",
        transactionType = "Send",
        transactionDate = "20 Jul 2024",
        transactionTime = "10:00 PM",
        reference = "123456789876",
        transactionStatus = "Successful",
        navController = rememberNavController()
    )
}