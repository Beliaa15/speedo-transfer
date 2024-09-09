package com.belia.speedotransfer.ui.common_ui

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.theme.titleMedium

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    color: Color,
    modifier: Modifier = Modifier,
    title: String = "",
    hasIcon: Boolean = false,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = titleMedium,
            )
        },
        navigationIcon = {
            if (hasIcon) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "back button"
                    )
                }
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = color
        ),
    )
}

@Preview
@Composable
private fun TopBarPrev() {
    TopBar(color = Color(0xFFFFF8E7), hasIcon = true, title = "Transfer")
}