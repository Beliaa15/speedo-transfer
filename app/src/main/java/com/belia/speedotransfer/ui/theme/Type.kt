package com.belia.speedotransfer.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.belia.speedotransfer.R

val InterFontFamily = FontFamily(
    Font(R.font.inter_regular),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semibold, FontWeight.SemiBold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val heading1 = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 32.sp,
    lineHeight = 48.sp // Assuming 150% of 32px
)

val heading2 = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 28.sp,
    lineHeight = 42.sp
)

val heading3 = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 24.sp,
    lineHeight = 36.sp
)

val titleSemiBold = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 20.sp,
    lineHeight = 30.sp
)

val titleMedium = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 20.sp,
    lineHeight = 30.sp
)

val bodyMedium16 = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
    lineHeight = 24.sp
)

val bodyRegular16 = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 24.sp
)

val bodyMedium14 = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 21.sp
)

val bodyRegular14 = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    lineHeight = 21.sp
)

val bodyRegular12 = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    lineHeight = 18.sp
)

val buttonMedium = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
    lineHeight = 21.sp
)

val linkMedium = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
    lineHeight = 21.sp
)

val linkRegular = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 21.sp
)

val smallRegular = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 10.sp,
    lineHeight = 12.sp
)