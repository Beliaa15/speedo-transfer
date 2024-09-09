package com.belia.speedotransfer.ui.main_screens.more.profile.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.belia.speedotransfer.ui.auth.components.CountryPicker
import com.belia.speedotransfer.ui.auth.components.DatePicker
import com.belia.speedotransfer.ui.auth.components.EmailTextField
import com.belia.speedotransfer.ui.common_ui.RedButton
import com.belia.speedotransfer.ui.common_ui.TopBar

@Composable
fun EditProfileScreen(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var countryName by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    listOf(Color(0xFFFFF8E7), Color(0xFFFFEAEE))
                )
            )
    ) {
        Scaffold(
            topBar = { TopBar(color = Color(0xFFFFF8E7), title = "Edit Profile", hasIcon = true) },
            modifier = modifier.padding(horizontal = 16.dp)
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
                //TODO(Add NameField after merging)
                EmailTextField {
                    email = it
                }
                CountryPicker {
                    countryName = it
                }
                DatePicker {
                    date = it
                }
                RedButton(text = "Save", onClick = { /*TODO*/ }, isEnabled = true)
            }
        }
    }
}
