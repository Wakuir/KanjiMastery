package fr.wakuir.kanjimastery.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import fr.wakuir.kanjimastery.R

// Common font family
val fontFamily = FontFamily.Default

// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle (
        fontFamily = fontFamily,
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
    ),

    titleSmall = TextStyle(
        fontFamily = fontFamily,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    ),

    bodyMedium = TextStyle (
        fontFamily = fontFamily,
        fontSize = 16.sp,
    ),

    bodyLarge = TextStyle (
        fontFamily = fontFamily,
        fontSize = 18.sp,
    )
)