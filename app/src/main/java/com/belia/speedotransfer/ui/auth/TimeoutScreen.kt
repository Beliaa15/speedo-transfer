package com.belia.speedotransfer.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.auth.components.EmailTextField
import com.belia.speedotransfer.ui.auth.components.PasswordTextField
import com.belia.speedotransfer.ui.common_ui.RedButton
import com.belia.speedotransfer.ui.theme.BottomRose
import com.belia.speedotransfer.ui.theme.bodyRegular12
import com.belia.speedotransfer.ui.theme.bodyRegular16
import com.belia.speedotransfer.ui.theme.heading3
import com.belia.speedotransfer.viewmodels.LoginViewModel
import com.belia.speedotransfer.viewmodels.SharedViewModel


@Composable
fun TimeOut(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = viewModel(),
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var validPassword by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(true) }

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(listOf(Color.White, BottomRose)))
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
            .imePadding()
    ) {
        Spacer(modifier = modifier.height(55.dp))

        if (showDialog) {
            InactivityCard(onDismiss = { showDialog = false })
        }

        Spacer(modifier = modifier.height(32.dp))

        Text(
            text = "Welcome Back",
            style = heading3,
            modifier = modifier
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = modifier.height(16.dp))

        Text(
            text = "Login to your account",
            style = bodyRegular16,
            color = Color(0xFF565552),
            modifier = modifier
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = modifier.height(33.dp))


        EmailTextField() {
            email = it
        }
        PasswordTextField(
            text = "Password",
            isPasswordShown = false,
            onChange = { password = it }
        ) {
            validPassword = it
        }

        Spacer(modifier = modifier.height(32.dp))


        RedButton(
            text = "Sign in",
            onClick = { viewModel.loginUser() },
            isEnabled = email.isNotBlank() && password.isNotBlank() && validPassword
        )
    }

}


@Composable
fun InactivityCard(onDismiss: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFE3E2E2),
                shape = RoundedCornerShape(6.dp)
            )
    ) {
        Row(
            modifier = Modifier.padding(vertical = 17.dp, horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.alert),
                contentDescription = "Alert",
                modifier = Modifier
                    .size(50.dp)
                    .padding(8.dp),
                alignment = Alignment.TopStart
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "We logged you out because you were inactive for 2 minutes - it’s to help your account secure",
                style = bodyRegular12,
                color = Color(0xFF565552),
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.height(8.dp))

            IconButton(
                onClick = onDismiss,
            ) {
                Icon(Icons.Default.Close, contentDescription = "Close")
            }
        }
    }

}

@Preview
@Composable
private fun TimeOutPrev() {
    //TimeOut(rememberNavController())
}

