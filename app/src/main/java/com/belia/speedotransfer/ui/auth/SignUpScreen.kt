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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.belia.speedotransfer.navigation.AppRoutes
import com.belia.speedotransfer.ui.auth.components.EmailTextField
import com.belia.speedotransfer.ui.auth.components.NameTextField
import com.belia.speedotransfer.ui.auth.components.PasswordTextField
import com.belia.speedotransfer.ui.common_ui.RedButton
import com.belia.speedotransfer.ui.theme.BottomRose
import com.belia.speedotransfer.ui.theme.GrayG100
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.InterFontFamily
import com.belia.speedotransfer.ui.theme.RedP300
import com.belia.speedotransfer.ui.theme.bodyRegular16
import com.belia.speedotransfer.ui.theme.linkMedium
import com.belia.speedotransfer.ui.theme.titleMedium
import com.belia.speedotransfer.viewmodels.SignUpViewModel


@Composable
fun SignUp(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel = viewModel()
) {
    var name by rememberSaveable  { mutableStateOf(viewModel.name) }
    var email by rememberSaveable  { mutableStateOf(viewModel.email) }
    var password by rememberSaveable  { mutableStateOf(viewModel.password) }
    var confirmPassword by rememberSaveable  { mutableStateOf(viewModel.confirmPassword) }
    var isPasswordShown by remember { mutableStateOf(false) }
    var validPassword by remember { mutableStateOf(false) }
    val passwordsMatch = password == confirmPassword

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(listOf(Color.White, BottomRose)))
            .padding(horizontal = 16.dp)
            .padding(top = 55.dp)
            .verticalScroll(rememberScrollState())
            .imePadding()
    ) {
        Text(
            text = "Sign Up",
            color = GrayG900,
            textAlign = TextAlign.Center,
            style = titleMedium,
            modifier = modifier
                .fillMaxWidth()
        )

        Spacer(modifier = modifier.height(55.dp))

        Text(
            text = "Speedo Transfer",
            fontWeight = FontWeight.W600,
            fontSize = 24.sp,
            fontFamily = InterFontFamily,
            color = GrayG900,
            textAlign = TextAlign.Center,
            modifier = modifier.fillMaxWidth()
        )

        Spacer(modifier = modifier.height(55.dp))
        NameTextField {
            name = it
            viewModel.name = it
        }
        EmailTextField {
            email = it
            viewModel.email = it
        }
        PasswordTextField(
            text = "Password",
            isPasswordShown = isPasswordShown,
            onChange = {
                password = it
                viewModel.password = it
            }
        ) {
            validPassword = it
        }
        PasswordTextField(
            text = "Confirm Password",
            isPasswordShown = isPasswordShown,
            onChange = {
                confirmPassword = it
                viewModel.confirmPassword = it
            }
        ) {
            validPassword = it
        }
        Spacer(modifier = modifier.height(32.dp))

        RedButton(
            text = "Sign up",
            onClick = {
                navController.navigate("${AppRoutes.SECONDSIGNUP}/$name/$email/$password")
            },
            isEnabled = email.isNotBlank() && password.isNotBlank() && validPassword && passwordsMatch
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
                .padding(all = 8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Already have an account? ",
                color = GrayG100,
                style = bodyRegular16,
            )
            Text(
                text = "Sign In",
                color = RedP300,
                style = linkMedium,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .padding(start = 2.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SignUpPreview() {
    SignUp(navController = rememberNavController())
}