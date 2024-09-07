package com.belia.speedotransfer.ui.transfer_screen.amount_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.belia.speedotransfer.ui.common_ui.RedButton
import com.belia.speedotransfer.ui.common_ui.StepProgressIndicator
import com.belia.speedotransfer.ui.common_ui.TopBar
import com.belia.speedotransfer.ui.theme.titleSemiBold

@Composable
fun AmountScreen(navController: NavController, modifier: Modifier = Modifier) {
    var amount by remember {
        mutableStateOf("")
    }

    var recipientName by remember {
        mutableStateOf("")
    }
    var recipientAccount by remember {
        mutableStateOf("")
    }

    val isButtonEnabled = amount.isNotBlank() && recipientName.isNotBlank() && recipientAccount.isNotBlank()

    Scaffold(
        topBar = {
            TopBar(color = Color(0xFFFFF8E7), hasIcon = true, title = "Transfer")
        }
    ) {
            innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        listOf(Color(0xFFFFF8E7), Color(0xFFFFEAEE))
                    )
                )
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            StepProgressIndicator(currentStep = 1)

            Text(
                text = "How much are you sending?",
                style = titleSemiBold,
                modifier = modifier.padding(vertical = 24.dp, horizontal = 16.dp)
            )
            AmountCard(
                amount = amount,
                onAmountChange = { amount = it }
            )
            RecipientInformation(
                name = recipientName,
                account = recipientAccount,
                onNameChange = { recipientName = it },
                onAccountChange = { recipientAccount = it }
            )
            RedButton(
                text = "Continue", onClick = {
                    // navController.navigate("$CONFIRMATION/$amount/$recipientName/$recipientAccount")
                    // TODO: Add navigation to confirmation screen
                },
                isEnabled = isButtonEnabled
            )
        }
    }
}

@Preview
@Composable
private fun AmountScreenPrev() {
    AmountScreen(navController = rememberNavController())
}