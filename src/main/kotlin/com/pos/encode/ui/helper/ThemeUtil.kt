package com.pos.encode.com.pos.encode.ui.helper

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.pos.encode.ui.theme.POSTheme

object ThemeUtil {

    @Composable
    fun getIconColor(index: Int, default: Int): Color {
        return if (index == default) POSTheme.colors.iconChecked else POSTheme.colors.icon
    }

}