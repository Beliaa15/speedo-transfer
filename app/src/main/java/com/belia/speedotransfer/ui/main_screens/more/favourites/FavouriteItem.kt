package com.belia.speedotransfer.ui.main_screens.more.favourites

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.theme.DangerD300
import com.belia.speedotransfer.ui.theme.GrayG100
import com.belia.speedotransfer.ui.theme.GrayG900
import com.belia.speedotransfer.ui.theme.RedP50
import com.belia.speedotransfer.ui.theme.bodyMedium16
import com.belia.speedotransfer.ui.theme.bodyRegular16
import com.belia.speedotransfer.viewmodels.FavouritesViewModel
import com.belia.speedotransfer.viewmodels.SharedViewModel
import com.belia.speedotransfer.viewmodels.UserViewModel

@Composable
fun FavouriteItem(
    account: String,
    name: String,
    sharedViewModel: SharedViewModel,
    modifier: Modifier = Modifier,
    viewModel: UserViewModel = viewModel(),
    favouritesViewModel: FavouritesViewModel = viewModel()
) {
    val userId by sharedViewModel.userId.collectAsState()
    viewModel.getUser(userId)
    val user by viewModel.user.collectAsState()
    val myAccount = user.account
    val context = LocalContext.current
    var isBottomSheetVisible by remember { mutableStateOf(false) }
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
            IconButton(onClick = {
                favouritesViewModel.deleteFavourite(myAccount.accountNumber, name, account)
                favouritesViewModel.getFavourites(userId)
                Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = "Delete Favourite",
                    tint = DangerD300
                )
            }
        }
    }

    EditFavouriteBottomSheet(
        isVisible = isBottomSheetVisible,
        onDismiss = { isBottomSheetVisible = false },
        oldName = name,
        oldAccount = account,
        favouritesViewModel = favouritesViewModel,
        sharedViewModel = sharedViewModel,
        myAccount = myAccount.accountNumber
    )
}