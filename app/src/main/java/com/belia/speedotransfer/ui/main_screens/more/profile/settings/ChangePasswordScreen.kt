package com.belia.speedotransfer.ui.main_screens.more.profile.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.belia.speedotransfer.ui.auth.components.PasswordTextField
import com.belia.speedotransfer.ui.common_ui.RedButton
import com.belia.speedotransfer.ui.common_ui.TopBar
import com.belia.speedotransfer.viewmodels.EditViewModel
import com.belia.speedotransfer.viewmodels.SharedViewModel

@Composable
fun ChangePasswordScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    modifier: Modifier = Modifier,
    viewModel: EditViewModel = viewModel()
) {
    val userId by sharedViewModel.userId.collectAsState()
    var curPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var isPasswordShown by remember { mutableStateOf(false) }
    var validPassword by remember { mutableStateOf(false) }

        Scaffold(
            topBar = {
                TopBar(
                    color = Color(0xFFFFF8E7),
                    title = "Change Password",
                    navController = navController,
                    hasIcon = true
                )
            },
        ) { innerPadding ->
            Column(
                modifier = modifier
                    .padding(top = innerPadding.calculateTopPadding())
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            listOf(Color(0xFFFFF8E7), Color(0xFFFFEAEE))
                        )
                    ),
            ) {
                Column(
                    modifier = modifier.padding(horizontal = 16.dp)
                ) {
                    Spacer(modifier = modifier.height(32.dp))
                    PasswordTextField(
                        text = "Current Password",
                        isPasswordShown = isPasswordShown,
                        onChange = {
                            curPassword = it
                            viewModel.oldpassword = it
                                   },
                    ) {
                        validPassword = it
                    }
                    PasswordTextField(
                        text = "New Password",
                        isPasswordShown = isPasswordShown,
                        onChange = {
                            newPassword = it
                            viewModel.newpassword = it
                        }
                    ) {
                        validPassword = it
                    }
                    Spacer(modifier = modifier.height(24.dp))
                    RedButton(
                        text = "Save",
                        onClick = {
                            viewModel.changePassword(userId)
                            navController.popBackStack()
                        },
                        isEnabled = curPassword.isNotBlank() && newPassword.isNotBlank() && validPassword
                    )
                }
            }
        }

}

@Preview
@Composable
private fun ASDASDsdas() {
//    ChangePasswordScreen(navController = rememberNavController())
}