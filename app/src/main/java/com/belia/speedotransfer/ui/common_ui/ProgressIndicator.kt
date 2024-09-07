package com.belia.speedotransfer.ui.common_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.belia.speedotransfer.ui.theme.GrayG700
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.RedP300
import com.belia.speedotransfer.ui.theme.bodyMedium14
import com.belia.speedotransfer.ui.theme.bodyRegular14

@Composable
fun StepProgressIndicator(currentStep: Int, modifier: Modifier = Modifier) {
    // Define the steps
    val steps = listOf("Amount", "Confirmation", "Payment")

    val activeColor = Color(0xFF871E35)
    val inactiveColor = Color(0xFFA3AAB2)

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            StepperItem(index = 0, currentStep = currentStep, step = "Amount")
            HorizontalDivider(
                color = if (currentStep > 0) activeColor else inactiveColor,
                thickness = 2.dp,
                modifier = Modifier
                    .width(85.dp)
            )
            StepperItem(index = 1, currentStep = currentStep, step = "Confirmation")
            HorizontalDivider(
                color = if (currentStep > 1) activeColor else inactiveColor,
                thickness = 2.dp,
                modifier = Modifier
                    .width(85.dp)
            )
            StepperItem(index = 2, currentStep = currentStep, step = "Payment")
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            steps.forEachIndexed { index, step ->
                Text(
                    text = step,
                    modifier = modifier.padding(top = 16.dp),
                    style = if (index < currentStep) bodyMedium14 else bodyRegular14,
                    color = if (index < currentStep) GrayG900 else GrayG700,
                )
            }
        }
    }
}

@Composable
fun StepperItem(index: Int, currentStep: Int, step: String, modifier: Modifier = Modifier) {
    val activeColor = RedP300
    val inactiveColor = Color(0xFFA3AAB2)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .size(36.dp)
                .background(
                    color = Color.White,
                    shape = CircleShape
                )
                .border(
                    width = 2.dp,
                    color = if (index < currentStep) activeColor else inactiveColor,
                    shape = CircleShape
                ),
        ) {
            Text(
                text = "0${index + 1}",
                fontSize = 15.sp,
                color = if (index < currentStep) activeColor else inactiveColor,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview(showSystemUi = false, showBackground = true, backgroundColor = 0xFFFFF8E7)
@Composable
private fun StepIndicatorPrev() {
    StepProgressIndicator(currentStep = 1)
}