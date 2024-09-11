package com.belia.speedotransfer.ui.main_screens.transfer_screen.amount_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.common_ui.RecipientTextField
import com.belia.speedotransfer.ui.theme.GrayG700
import com.belia.speedotransfer.ui.theme.RedP300
import com.belia.speedotransfer.ui.theme.bodyMedium16
import com.belia.speedotransfer.viewmodels.SharedViewModel

@Composable
fun RecipientInformation(
    name: String,
    account: String,
    onNameChange: (String) -> Unit,
    onAccountChange: (String) -> Unit,
    sharedViewModel: SharedViewModel,
    modifier: Modifier = Modifier
) {
    var isBottomSheetVisible by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            //verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = "Recipient Information",
                color = GrayG700,
                style = bodyMedium16
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .clickable {
                        isBottomSheetVisible = true
                    }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_fav),
                    contentDescription = "Favourites Icon",
                    tint = RedP300,
                    modifier = modifier
                        .size(16.dp)
                )
                Spacer(modifier = modifier.width(4.dp))
                Text(
                    text = "Favourite",
                    color = RedP300,
                    style = bodyMedium16
                )
                Spacer(modifier = modifier.width(4.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "Forward icon",
                    tint = RedP300,
                    modifier = modifier
                        .size(16.dp)
                        .rotate(180f)
                )
            }
        }
        Spacer(modifier = modifier.height(20.dp))
        RecipientTextField(title = "Recipient Name", placeholder = "Enter Recipient Name", onChange = onNameChange)

        RecipientTextField(title = "Recipient Account", placeholder = "Enter Recipient Account Number", onChange = onAccountChange)

        FavouriteBottomSheet(
            sharedViewModel = sharedViewModel,
            isVisible = isBottomSheetVisible,
            onDismiss = {isBottomSheetVisible = false}
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun RecipientInformationPreview() {
    //RecipientInformation("", "", {}, {})
}