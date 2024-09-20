package com.belia.speedotransfer.ui.auth.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.theme.GrayG10
import com.belia.speedotransfer.ui.theme.GrayG70
import com.belia.speedotransfer.ui.theme.GrayG700
import com.belia.speedotransfer.ui.theme.RedP300
import com.belia.speedotransfer.ui.theme.bodyRegular16
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePicker(modifier: Modifier = Modifier, onClick: (String) -> Unit) {
    var date by rememberSaveable { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }

    Text(
        text = "Date Of Brith",
        style = bodyRegular16,
        color = GrayG700,
        modifier = modifier.padding(vertical = 8.dp)
    )
    OutlinedTextField(
        value = date,
        enabled = false,
        colors = OutlinedTextFieldDefaults.colors(
            disabledTrailingIconColor = GrayG70,
            disabledContainerColor = GrayG10,
            disabledBorderColor = GrayG70,
            disabledPlaceholderColor = GrayG70,
        ),
        onValueChange = { date = it },
        shape = RoundedCornerShape(6.dp),
        placeholder = { Text(text = "DD/MM/YYYY", color = GrayG70) },

        readOnly = true,

        trailingIcon = {
            IconButton(onClick = { isFocused = true }) {
                Icon(
                    painter = painterResource(id = R.drawable.calender),
                    contentDescription = "select a date ",
                    modifier = modifier.size(24.dp)
                )
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .clickable { isFocused = true },
    )
    if (isFocused) {
        DatePickerChooser(
            onConfirm = {
                var c = Calendar.getInstance()
                c.timeInMillis =
                    it.selectedDateMillis!! // calender class is used to convert from ms to date
                var dateFormatter = SimpleDateFormat("yyyy/MM/dd", Locale.US)
                date = dateFormatter.format(c.time)
                onClick(date)
                isFocused = false
            },
            onDismiss = {
                isFocused = false
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerChooser(onConfirm: (DatePickerState) -> Unit, onDismiss: () -> Unit) {
    val datePickerState = rememberDatePickerState()
    DatePickerDialog(
        onDismissRequest = {},
        confirmButton = {
            TextButton(onClick = { onConfirm(datePickerState) }) {
                Text(text = "Ok", color = RedP300)
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text(text = "Cancel", color = RedP300)
            }
        }
    ) {
        DatePicker(
            state = datePickerState,
            colors = DatePickerDefaults.colors(
                selectedDayContainerColor = RedP300,
                selectedYearContainerColor = RedP300,
                todayContentColor = RedP300,
                todayDateBorderColor = RedP300,
            ),
        )
    }
}


@Preview(showBackground = true, showSystemUi = false)
@Composable
private fun DatePreview() {
    DatePicker() {

    }
}