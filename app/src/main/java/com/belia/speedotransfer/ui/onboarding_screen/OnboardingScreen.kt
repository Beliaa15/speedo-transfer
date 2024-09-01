package com.belia.speedotransfer.ui.onboarding_screen

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.theme.GrayG700
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.RedP300
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(
        pageCount = { 2 }
    )
    val scope = rememberCoroutineScope()

    BackHandler(enabled = pagerState.currentPage > 0) {
        scope.launch {
            pagerState.animateScrollToPage(pagerState.currentPage - 1)
        }
    }

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFFFFFFF), Color(0xFFFFEAEE))
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Button(
            onClick = {OnBoard()},
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = RedP300
            )
        ) {
            Text("Exit")
        }

        TextButton(
            onClick = {OnBoard()},
            modifier = modifier
                .align(Alignment.End)
                .padding(top = 16.dp)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Skip",
                color = RedP300,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }
        OnBoardingScreenDesign(
            image = R.drawable.loading_rafiki,
            title = R.string.amount,
            description = R.string.amount_description,
            pagerState
        )


        Button(
            onClick = {OnBoard()},
            modifier = Modifier
                .padding(8.dp)
                .height(30.dp),
            shape = RoundedCornerShape(12.dp),
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

fun OnBoard() {
    Log.d("trace", "OnBoard")
}
