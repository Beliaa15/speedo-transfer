package com.belia.speedotransfer.ui.common_ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.belia.speedotransfer.ui.theme.GrayG10
import com.belia.speedotransfer.ui.theme.GrayG70
import com.belia.speedotransfer.ui.theme.GrayG700
import com.belia.speedotransfer.ui.theme.bodyRegular16

@Composable
fun RecipientTextField(
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
        modifier = modifier.padding(vertical = 8.dp)
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
            .onFocusChanged {
                isFocused = value.isNotBlank()
            },
    )
}