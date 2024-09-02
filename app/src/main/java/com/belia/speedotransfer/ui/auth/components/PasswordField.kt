package com.belia.speedotransfer.ui.auth.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.theme.DangerD300
import com.belia.speedotransfer.ui.theme.GrayG10
import com.belia.speedotransfer.ui.theme.GrayG70
import com.belia.speedotransfer.ui.theme.GrayG700

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    text: String,
    isPasswordShown: Boolean,
    onChange: (String) -> Unit,
    isPasswordValid: (Boolean) -> Unit
) {
    val context = LocalContext.current
    var tempPassword by remember { mutableStateOf("") }
    var tempIsPasswordShown by remember { mutableStateOf(isPasswordShown) }
    var passwordConstraintsText by remember { mutableStateOf("") }
    isPasswordValid(passwordConstraintsText == "")
    var isFocused by remember { mutableStateOf(false) }


    Text(
        text = text,
        color = GrayG700,
        textAlign = TextAlign.Start,
        fontSize = 16.sp,
        modifier = modifier.padding(vertical = 8.dp),
    )
    OutlinedTextField(
        value = tempPassword,
        onValueChange = {
            tempPassword = it
            onChange(tempPassword)
            if (text != "Current Password") {
                passwordConstraints(tempPassword) { returnedText ->
                    passwordConstraintsText = returnedText
                }
            }
        },
        placeholder = { Text(text = "Enter your password ") },
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
        shape = RoundedCornerShape(6.dp),
        visualTransformation = if (tempIsPasswordShown) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val id = if (!tempIsPasswordShown) R.drawable.eye else R.drawable.close_eye
            IconButton(onClick = { tempIsPasswordShown = !tempIsPasswordShown }) {
                Icon(
                    painter = painterResource(id = id),
                    contentDescription = "password icon",
                    modifier = Modifier.size(24.dp),
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .onFocusChanged {
                isFocused = tempPassword.isNotBlank()
            },
    )

    Text(text = passwordConstraintsText, color = Color.Red)
}


fun passwordConstraints(password: String, onClick: (String) -> Unit) {
    val lowercaseLetter = Regex("[a-z]")
    val uppercaseLetter = Regex("[A-Z]")
    val special = Regex("[!\"#\$%&'()*+,-./:;<=>?@\\]^_`{|}~]")

    val hasLowercaseLetter = lowercaseLetter.containsMatchIn(password)
    val hasUppercaseLetter = uppercaseLetter.containsMatchIn(password)
    val hasSpecial = special.containsMatchIn(password)
    if (password.isBlank())
        onClick("Your password must not be empty")
    else if (password.length < 6)
        onClick("Your password must be at least 6 characters long ")
    else if (!hasLowercaseLetter)
        onClick("Your password must have at least 1 lowercase letter")
    else if (!hasUppercaseLetter)
        onClick("Your password must have at least 1 uppercase letter")
    else if (!hasSpecial)
        onClick("Your password must have at least 1 special character")
    else
        onClick("")
}
