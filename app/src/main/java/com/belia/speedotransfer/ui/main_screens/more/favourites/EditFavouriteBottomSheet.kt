package com.belia.speedotransfer.ui.main_screens.more.favourites

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.common_ui.RecipientTextField
import com.belia.speedotransfer.ui.common_ui.RedButton
import com.belia.speedotransfer.ui.theme.GrayG700
import com.belia.speedotransfer.ui.theme.RedP300
import com.belia.speedotransfer.ui.theme.bodyRegular16

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditFavouriteBottomSheet(
    isVisible: Boolean,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (isVisible) {
        val state = rememberModalBottomSheetState()
        ModalBottomSheet(
            sheetState = state,
            onDismissRequest = onDismiss,
            containerColor = Color.White
        ) {
            var account by remember { mutableStateOf("") }
            var name by remember { mutableStateOf("") }
            val context = LocalContext.current
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_edit),
                        contentDescription = "Edit Favourite",
                        tint = RedP300
                    )
                    Text(
                        text = "Edit",
                        style = bodyRegular16,
                        fontSize = 20.sp,
                        color = GrayG700,
                        modifier = modifier.padding(start = 8.dp)
                    )
                }

                RecipientTextField(
                    title = "Recipient Account",
                    placeholder = "Enter Cardholder Account"
                ) {
                    account = it
                }

                RecipientTextField(
                    title = "Recipient Name",
                    placeholder = "Enter Cardholder Name"
                ) {
                    name = it
                }
                Spacer(modifier = modifier.height(20.dp))
                RedButton(
                    text = "Save",
                    onClick = {
                        // TODO: Handle save action
                        onDismiss()
                        Toast.makeText(context, "Edited Successfully", Toast.LENGTH_SHORT).show()
                    },
                    isEnabled = name.isNotBlank() && account.isNotBlank(),
                    //modifier = modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = modifier.height(50.dp))
            }
        }
    }
}