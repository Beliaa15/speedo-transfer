package com.belia.speedotransfer.ui.common_ui

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.belia.speedotransfer.R
import com.belia.speedotransfer.navigation.AppRoutes
import com.belia.speedotransfer.ui.theme.GrayG0
import com.belia.speedotransfer.ui.theme.GrayG200
import com.belia.speedotransfer.ui.theme.InterFontFamily
import com.belia.speedotransfer.ui.theme.RedP300
import com.belia.speedotransfer.ui.theme.bodyRegular16
import com.belia.speedotransfer.ui.theme.smallRegular

data class BottomNavigationItem(
    val title: String,
    val route: String,
    val icon: ImageVector,
)

@Composable
fun SpeedoNavigationBar(
    selectedIndex: Int,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val navigationItems = listOf(
        BottomNavigationItem(
            title = "Home",
            route = AppRoutes.HOME,
            icon = ImageVector.vectorResource(id = R.drawable.ic_nav_home)
        ),
        BottomNavigationItem(
            title = "Transfer",
            route = AppRoutes.TRANSFER,
            icon = ImageVector.vectorResource(id = R.drawable.ic_nav_transfer)
        ),
        BottomNavigationItem(
            title = "Transactions",
            route = AppRoutes.TRANSACTIONS,
            icon = ImageVector.vectorResource(id = R.drawable.ic_nav_transcations)
        ),
        BottomNavigationItem(
            title = "My cards",
            route = AppRoutes.MYCARDS,
            icon = ImageVector.vectorResource(id = R.drawable.ic_nav_mycards)
        ),
        BottomNavigationItem(
            title = "More",
            route = AppRoutes.MORE,
            icon = ImageVector.vectorResource(id = R.drawable.ic_nav_more)
        )
    )

    val selectedItem by rememberSaveable {
        mutableIntStateOf(selectedIndex)
    }

    Surface(
        color = GrayG0,
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        modifier = Modifier.height(83.dp)
    ) {
        NavigationBar(
            containerColor = GrayG0,
            modifier = modifier
            //.background(color = Color.Transparent)
        ) {
            navigationItems.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = index == selectedItem,
                    onClick = {
                        if(item.route.isNotEmpty() && index != selectedItem)
                            navController.navigate(item.route)
                    },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = if (index == selectedItem) RedP300 else GrayG200,
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            color = if (index == selectedItem) RedP300 else GrayG200,
                            style = smallRegular,
                            maxLines = 1,
                        )
                    },
                    alwaysShowLabel = true,
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent,
                    ),
                )
            }
        }
    }
}
@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun SpeedoNavigationBarPrev() {
    SpeedoNavigationBar(selectedIndex = 0, rememberNavController())
}