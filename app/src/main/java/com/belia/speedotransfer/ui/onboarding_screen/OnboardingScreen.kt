package com.belia.speedotransfer.ui.onboarding_screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.RedP300
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(
        pageCount = { 3 }
    )
    val scope = rememberCoroutineScope()

    BackHandler (enabled = pagerState.currentPage > 0){
        scope.launch {
            pagerState.animateScrollToPage(pagerState.currentPage - 1)
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFFFFFFF), Color(0xFFFFEAEE))
                )
            )
    ) {
        TextButton(
            onClick = {
                // TODO: Login Screen
            },
            modifier = modifier
                .align(Alignment.End)
                .padding(top = 16.dp)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Skip",
                color = GrayG900
            )
        }
        HorizontalPager(
            state = pagerState,
            verticalAlignment = Alignment.Top,
            //pageSize = PageSize.Fill,
            modifier = modifier
                .fillMaxWidth()
                //.weight(1f)
                .padding(16.dp)
        ) { page ->
            when (page) {
                0 -> OnBoardingScreenDesign(
                    image = R.drawable.loading_rafiki,
                    title = R.string.amount,
                    description = R.string.amount_description,
                    pagerState
                )
                1 -> OnBoardingScreenDesign(
                    image = R.drawable.currency_rafiki,
                    title = R.string.confirmation,
                    description = R.string.confirmation_description,
                    pagerState
                )
                2 -> OnBoardingScreenDesign(
                    image = R.drawable.payments_rafiki,
                    title = R.string.payment,
                    description = R.string.payment_description,
                    pagerState
                )
            }
        }
        Button(
            onClick = {
                if (pagerState.currentPage < 2) {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                } else {
                    // Navigate to the next screen or close onboarding
                    // TODO: Login Screen
                }
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = RedP300
            )
        ) {
            Text("Next")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun OnboardingScreenPrev() {
    OnboardingScreen()
}