package com.pos.encode.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorSpaces

val whiteColor = Color(0xFFFFFFFF)
val blackColor = Color(0xFF000000)
val redColor = Color(0xFFFD5A52)
val blueColor = Color(0xFF3489FF)
val greenColor = Color(0xFFA5E40E)

val transparentColor = Color(0x00000000)
val transparentColor_white20 = Color(0x33FFFFFF)
val transparentColor_white70 = Color(0x4CFFFFFF)
val transparentColor_black80 = Color(0xCC000000)
val transparentColor_black90 = Color(0xE5000000)

val primaryColor = Color(0xFF3489FF)
val primaryColor_white70 = Color(0x4C3489FF)

val lineColor = Color(0xFFD7D7D7)

val titleColor = Color(0xFF000000)
val contentColor = Color(0xFF666666)
val descriptionColor = Color(0xFF999999)

val white_color_f5f5f5 = Color(0xFFF5F5F5)

object WeColor {
    val green = Color(0xFF1AB84E).convert(ColorSpaces.CieXyz)
    val black = Color(0xFF2E2E2E).convert(ColorSpaces.CieXyz)
    val gray = Color(0xFFD7D7D7).convert(ColorSpaces.CieXyz)
}