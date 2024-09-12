package com.belia.speedotransfer.ui.splash_screen

import PreferencesHelper
import android.content.Context
import android.view.animation.BounceInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.belia.speedotransfer.navigation.AppRoutes
import com.belia.speedotransfer.navigation.AppRoutes.LOGIN
import com.belia.speedotransfer.navigation.AppRoutes.ONBOARDING
import com.belia.speedotransfer.ui.theme.InterFontFamily
import com.belia.speedotransfer.ui.theme.RedP500
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, context: Context) {
    val scale = remember { Animatable(0.3f) }
    val preferencesHelper = PreferencesHelper(context)
    var destination = ""
    if (preferencesHelper.isOnboardingCompleted) {
        destination =  LOGIN
    } else {
        preferencesHelper.isOnboardingCompleted = true
        destination = ONBOARDING
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 1000,
                easing = { BounceInterpolator().getInterpolation(it) }
            )
        )
        delay(2000L)
        navController.navigate(destination){
            popUpTo(AppRoutes.SPLASH) { inclusive = true }
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(RedP500),
    ) {
        Text(
            text = "Speedo Transfer",
            fontSize = 45.sp,
            fontFamily = InterFontFamily,
            fontWeight = FontWeight.W400,
            color = Color.White,
            modifier = Modifier.scale(scale.value)
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun SplashScreenPreview() {
//    SplashScreen(rememberNavController())
}