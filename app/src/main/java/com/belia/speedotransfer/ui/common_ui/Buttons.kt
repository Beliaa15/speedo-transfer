package com.belia.speedotransfer.ui.common_ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belia.speedotransfer.ui.theme.GrayG0
import com.belia.speedotransfer.ui.theme.GrayG100
import com.belia.speedotransfer.ui.theme.GrayG40
import com.belia.speedotransfer.ui.theme.RedP300
import com.belia.speedotransfer.ui.theme.buttonMedium

@Composable
fun RedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = RedP300,
            contentColor = GrayG0,
            disabledContainerColor = GrayG100,
            disabledContentColor = GrayG40
        ),
        enabled = isEnabled,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            style = buttonMedium,
            modifier = modifier.padding(vertical = 10.dp)
        )
    }
}

@Composable
fun EmptyButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(6.dp),
        border = BorderStroke(
            width = (1.5).dp,
            color = RedP300
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = RedP300
        ),
        enabled = true,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
    ) {
        Text(
            text = text,
            style = buttonMedium,
            modifier = modifier.padding(vertical = 10.dp)
        )
    }
}

@Preview
@Composable
private fun ButtonPreview() {
    // EmptyButton("Continue", {})
    RedButton("Continue", {}, isEnabled = false)
}