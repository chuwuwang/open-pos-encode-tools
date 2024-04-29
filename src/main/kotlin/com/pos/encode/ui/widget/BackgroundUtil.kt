package com.pos.encode.com.pos.encode.ui.widget

import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import com.pos.encode.ui.theme.POSTheme

object BackgroundUtil {

    val inputTextFieldColor: TextFieldColors
        @Composable get() = TextFieldDefaults.outlinedTextFieldColors(textColor = POSTheme.colors.contentText, cursorColor = POSTheme.colors.borderChecked, unfocusedBorderColor = POSTheme.colors.border, focusedBorderColor = POSTheme.colors.borderChecked)

}