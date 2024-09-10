package com.belia.speedotransfer.ui.main_screens.transfer_screen.amount_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.theme.RedP300
import com.belia.speedotransfer.ui.theme.bodyRegular16


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouriteBottomSheet(
    isVisible: Boolean,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    val state = rememberModalBottomSheetState()
    if (isVisible) {
        ModalBottomSheet(
            sheetState = state,
            content = {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                        .imePadding(),
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_fav),
                            contentDescription = "Edit Favourite",
                            tint = RedP300
                        )
                        Text(
                            text = "Favourite List",
                            style = bodyRegular16,
                            fontSize = 20.sp,
                            color = RedP300,
                            modifier = modifier.padding(start = 8.dp)
                        )
                    }
                    ASFavouriteItem(account = "asdasd", name = "asdasd")
                    ASFavouriteItem(account = "asdasd", name = "asdasd")
                    ASFavouriteItem(account = "asdasd", name = "asdasd")
                    ASFavouriteItem(account = "asdasd", name = "asdasd")
                    ASFavouriteItem(account = "asdasd", name = "asdasd")
                    ASFavouriteItem(account = "asdasd", name = "asdasd")
                }
            },
            onDismissRequest = { onDismiss() },
            containerColor = Color.White
        )
    }
}
