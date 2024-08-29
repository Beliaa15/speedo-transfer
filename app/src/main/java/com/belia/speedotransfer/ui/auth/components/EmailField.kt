package com.belia.speedotransfer.ui.auth.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.theme.DangerD300
import com.belia.speedotransfer.ui.theme.GrayG10
import com.belia.speedotransfer.ui.theme.GrayG70
import com.belia.speedotransfer.ui.theme.GrayG700

@Composable
fun EmailTextField(modifier: Modifier = Modifier, onChange: (String) -> Unit) {
    var textFieldEmail by remember { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }

    Text(
        text = "Email",
        color = GrayG700,
        textAlign = TextAlign.Start,
        fontSize = 16.sp,
        modifier = modifier.padding(vertical = 8.dp)
    )
    OutlinedTextField(
        value = textFieldEmail,
        onValueChange = {
            textFieldEmail = it
            onChange(it)
        },
        placeholder = { Text(text = "Enter your email address") },
        maxLines = 1,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = if (isFocused) GrayG700 else GrayG70,
            unfocusedTrailingIconColor = if (isFocused) GrayG700 else GrayG70,
            unfocusedLabelColor = if (isFocused) GrayG700 else GrayG70,
            unfocusedContainerColor = GrayG10,
            unfocusedPlaceholderColor = GrayG70,
            focusedBorderColor = GrayG700,
            focusedContainerColor = GrayG10,
            focusedTrailingIconColor = GrayG700,
            focusedLabelColor = GrayG700,
            errorContainerColor = DangerD300,
            errorTrailingIconColor = DangerD300,
            cursorColor = GrayG700
        ),
        shape = RoundedCornerShape(7.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_email),
                contentDescription = "email icon",
                modifier = Modifier.size(24.dp),
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .onFocusChanged {
                isFocused = textFieldEmail.isNotBlank()
            },
    )
}

@Preview(showBackground = true)
@Composable
private fun EmailTextFieldPreview() {

}