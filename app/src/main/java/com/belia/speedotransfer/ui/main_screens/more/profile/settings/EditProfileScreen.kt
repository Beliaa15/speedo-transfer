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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.belia.speedotransfer.ui.auth.components.CountryPicker
import com.belia.speedotransfer.ui.auth.components.DatePicker
import com.belia.speedotransfer.ui.auth.components.EmailTextField
import com.belia.speedotransfer.ui.auth.components.NameTextField
import com.belia.speedotransfer.ui.common_ui.RedButton
import com.belia.speedotransfer.ui.common_ui.TopBar
import com.belia.speedotransfer.viewmodels.EditViewModel
import com.belia.speedotransfer.viewmodels.SharedViewModel
import com.belia.speedotransfer.viewmodels.UserViewModel

@Composable
fun EditProfileScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    modifier: Modifier = Modifier,
    viewModel: EditViewModel = viewModel(),
    userViewModel: UserViewModel = viewModel(),
) {
    val userId by sharedViewModel.userId.collectAsState()
    userViewModel.getUser(userId)
    val user = userViewModel.user.collectAsState()
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var countryName by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }


    Scaffold(
        topBar = {
            TopBar(
                color = Color(0xFFFFF8E7),
                navController = navController,
                title = "Edit Profile",
                hasIcon = true
            )
        },
    ) { innerPadding ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        listOf(Color(0xFFFFF8E7), Color(0xFFFFEAEE))
                    )
                )
        ) {
            Column(
                modifier = modifier
                    .padding(top = innerPadding.calculateTopPadding())
                    .padding(horizontal = 16.dp)
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            listOf(Color(0xFFFFF8E7), Color(0xFFFFEAEE))
                        )
                    ),
            ) {
                NameTextField {
                    name = it
                    viewModel.name = it
                }
                EmailTextField {
                    email = it
                    viewModel.email = it
                }
                CountryPicker {
                    countryName = it
                    viewModel.country = it
                }
                DatePicker {
                    date = it
                    viewModel.dateOfBirth = it
                }
                Spacer(modifier = modifier.height(24.dp))
                RedButton(
                    text = "Save",
                    onClick = {
                        if(name.isBlank()) viewModel.name = user.value.name
                        if(email.isBlank()) viewModel.email = user.value.email
                        if(countryName.isBlank()) viewModel.country = user.value.country
                        if(date.isBlank()) viewModel.dateOfBirth = user.value.dob
                        viewModel.editProfile(userId)
                        navController.popBackStack()
                    },
                    isEnabled = name.isNotBlank() || email.isNotBlank() || countryName.isNotBlank() || date.isNotBlank()
                )
            }
        }
    }
}
