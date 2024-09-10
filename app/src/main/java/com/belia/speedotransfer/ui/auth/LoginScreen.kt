package com.belia.speedotransfer.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.belia.speedotransfer.ui.auth.components.EmailTextField
import com.belia.speedotransfer.ui.auth.components.PasswordTextField
import com.belia.speedotransfer.ui.common_ui.RedButton
import com.belia.speedotransfer.ui.theme.BottomRose
import com.belia.speedotransfer.ui.theme.GrayG0
import com.belia.speedotransfer.ui.theme.GrayG100
import com.belia.speedotransfer.ui.theme.GrayG40
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.RedP300
import com.belia.speedotransfer.ui.theme.RedP75
import com.belia.speedotransfer.ui.theme.bodyRegular16
import com.belia.speedotransfer.ui.theme.buttonMedium
import com.belia.speedotransfer.ui.theme.linkMedium
import com.belia.speedotransfer.ui.theme.titleMedium
import com.belia.speedotransfer.ui.theme.titleSemiBold


@Composable
fun Login(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var validPassword by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(listOf(Color.White, BottomRose)))
            .padding(horizontal = 16.dp, vertical = 56.dp)
            .verticalScroll(rememberScrollState())
            .imePadding()
    ) {
        Text(
            text = "Sign In",
            color = GrayG900,
            textAlign = TextAlign.Center,
            style = titleMedium,
            modifier = modifier
                .fillMaxWidth()
        )

        Spacer(modifier = modifier.height(64.dp))

        Text(
            text = "Speedo Transfer",
            color = GrayG900,
            textAlign = TextAlign.Center,
            style = titleSemiBold,
            modifier = modifier.fillMaxWidth()
        )

        Spacer(modifier = modifier.height(56.dp))

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

        Spacer(modifier = modifier.height(16.dp))

        RedButton(
            text = "Sign in",
            onClick = { /*TODO*/ },
            isEnabled = email.isNotBlank() && password.isNotBlank() && validPassword
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
                .padding(all = 8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Don’t have an account? ",
                color = GrayG100,
                style = bodyRegular16
            )
            Text(
                text = "Sign Up",
                color = RedP300,
                style = linkMedium,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .padding(start = 2.dp)
                    .clickable { /*TODO go to Sign up*/ }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LoginPreview() {
    Login(rememberNavController())
}