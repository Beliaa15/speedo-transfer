package com.belia.speedotransfer.ui.main_screens.more.favourites


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.common_ui.RedButton
import com.belia.speedotransfer.ui.common_ui.SpeedoNavigationBar
import com.belia.speedotransfer.ui.common_ui.TopBar
import com.belia.speedotransfer.ui.theme.DangerD300
import com.belia.speedotransfer.ui.theme.GrayG10
import com.belia.speedotransfer.ui.theme.GrayG100
import com.belia.speedotransfer.ui.theme.GrayG70
import com.belia.speedotransfer.ui.theme.GrayG700
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.RedP300
import com.belia.speedotransfer.ui.theme.RedP50
import com.belia.speedotransfer.ui.theme.bodyMedium16
import com.belia.speedotransfer.ui.theme.bodyRegular16
import com.belia.speedotransfer.ui.theme.titleSemiBold

@Composable
fun FavouriteScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopBar(color = Color(0xFFFFF8E7), navController, title = "Favourites", hasIcon = true)
        },
        bottomBar = {
            SpeedoNavigationBar(selectedIndex = 4, navController)
        },
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding())
                .background(
                    brush = Brush.linearGradient(
                        listOf(Color(0xFFFFF8E7), Color(0xFFFFEAEE))
                    )
                )
                .verticalScroll(rememberScrollState())
                .imePadding(),
        ) {
            Text(
                text = "Your Favourites List",
                style = titleSemiBold,
                modifier = modifier.padding(top = 20.dp, bottom = 16.dp),
            )

            //TODO("Add favourite list from database")

            FavouriteItem(account = "Belia", name = "Belia")
            FavouriteItem(account = "Belia", name = "Belia")
            FavouriteItem(account = "Belia", name = "Belia")
            FavouriteItem(account = "Belia", name = "Belia")

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouriteItem(account: String, name: String, modifier: Modifier = Modifier) {
    var isBottomSheetVisible by remember { mutableStateOf(false) }
    val state = rememberModalBottomSheetState()
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(100.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = RedP50)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxSize()
                .background(color = RedP50)
                .padding(start = 16.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.circle_favourite),
                contentDescription = "Favourite Contact",
                modifier = modifier.padding()
            )
            Column(
                modifier = modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            ) {
                Text(text = name, style = bodyMedium16, color = GrayG900)
                Spacer(modifier = modifier.height(8.dp))
                Text(text = account, style = bodyRegular16, color = GrayG100)
            }
            IconButton(onClick = { isBottomSheetVisible = true }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_edit),
                    contentDescription = "Edit Favourite",
                    tint = GrayG100
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = "Delete Favourite",
                    tint = DangerD300
                )
            }
        }
    }

    if (isBottomSheetVisible) {
        ModalBottomSheet(
            sheetState = state,
            content = {
                var account by remember { mutableStateOf("") }
                var name by remember { mutableStateOf("") }
                var context = LocalContext.current
                Column(
                    modifier = modifier
                        .fillMaxWidth(),
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

                    EditTextField(title = "Recipient Account", placeholder = "Enter Cardholder Account") {
                        account = it
                    }

                    EditTextField(title = "Recipient Name", placeholder = "Enter Cardholder Name") {
                        name = it
                    }
                    Spacer(modifier = modifier.height(20.dp))
                    RedButton(
                        text = "Save",
                        onClick = {
                            /*TODO*/
                            isBottomSheetVisible = false
                            Toast.makeText(context, "Edited Successfully", Toast.LENGTH_SHORT).show()
                        },
                        isEnabled = name.isNotBlank() && account.isNotBlank(),
                    )
                    Spacer(modifier = modifier.height(50.dp))
                }
            },
            onDismissRequest = { isBottomSheetVisible = false },
            containerColor = Color.White
        )
    }
}


@Composable
fun EditTextField(
    title: String,
    placeholder: String,
    modifier: Modifier = Modifier,
    onChange: (String) -> Unit
) {
    var value by remember { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }

    Text(
        text = title,
        color = GrayG700,
        textAlign = TextAlign.Start,
        style = bodyRegular16,
        modifier = modifier.padding(vertical = 8.dp, horizontal = 16.dp)
    )

    OutlinedTextField(
        value = value,
        onValueChange = {
            value = it
            onChange(it)
        },
        placeholder = { Text(text = placeholder) },
        maxLines = 1,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = if (isFocused) GrayG700 else GrayG70,
            unfocusedLabelColor = if (isFocused) GrayG700 else GrayG70,
            unfocusedContainerColor = GrayG10,
            unfocusedPlaceholderColor = GrayG70,
            focusedBorderColor = GrayG700,
            focusedContainerColor = GrayG10,
            focusedLabelColor = GrayG700,
            cursorColor = GrayG700
        ),
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .onFocusChanged {
                isFocused = value.isNotBlank()
            },
    )
}


@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun FavouriteItemPreview() {
    //FavouriteItem(account = "a2s1d32as1321asd", name = "asdasdasd")
    //FavouriteScreen()
//    EditTextField(title = "asdasd", placeholder = "asdasd"){ }
    //FavouriteBottomSheet()
}