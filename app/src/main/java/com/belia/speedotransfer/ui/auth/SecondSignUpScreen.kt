package com.belia.speedotransfer.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.belia.speedotransfer.ui.auth.components.CountryPicker
import com.belia.speedotransfer.ui.auth.components.DatePicker
import com.belia.speedotransfer.ui.common_ui.RedButton
import com.belia.speedotransfer.ui.common_ui.TopBar
import com.belia.speedotransfer.ui.theme.BottomRose
import com.belia.speedotransfer.ui.theme.GrayG100
import com.belia.speedotransfer.ui.theme.GrayG700
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.InterFontFamily
import com.belia.speedotransfer.ui.theme.RedP300
import com.belia.speedotransfer.ui.theme.bodyRegular16
import com.belia.speedotransfer.ui.theme.heading3
import com.belia.speedotransfer.ui.theme.linkMedium

@Composable
fun SecondSignUp(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var countryName by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopBar(color = Color.White, navController, hasIcon = true, title = "", modifier = modifier)
        }
    ) { _ ->

        Column(
            verticalArrangement = Arrangement.Top,
            modifier = modifier
                .fillMaxSize()
                .background(brush = Brush.verticalGradient(listOf(Color.White, BottomRose)))
                .padding(horizontal = 16.dp)
                .padding(top = 55.dp),
        ) {

            Spacer(modifier = modifier.padding(top = 55.dp))

            Text(
                text = "Speedo Transfer",
                fontWeight = FontWeight.W600,
                fontSize = 24.sp,
                fontFamily = InterFontFamily,
                color = GrayG900,
                textAlign = TextAlign.Center,
                modifier = modifier.fillMaxWidth()
            )

            Spacer(modifier = modifier.padding(28.dp))

            Text(
                text = "Welcome to Banque Misr!",
                color = GrayG900,
                modifier = modifier
                    .padding(bottom = 6.dp)
                    .fillMaxWidth(),
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                style = heading3
            )

            Spacer(modifier = modifier.padding(6.dp))

            Text(
                text = "Let’s Complete your Profile",
                color = GrayG700,
                modifier = modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                style = bodyRegular16
            )

            Spacer(modifier = modifier.padding(16.dp))

            CountryPicker {
                countryName = it
            }

            DatePicker {
                date = it
            }

            Spacer(modifier = modifier.padding(12.dp))

            RedButton(text = "Continue", onClick = { /*TODO*/ }, isEnabled = date.isNotBlank() && countryName.isNotBlank() )

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
                        .clickable { /*TODO go to Sign up*/ }
                )
            }
        }
    }
}

@Preview
@Composable
private fun prevvvv() {
    SecondSignUp(rememberNavController())
}
