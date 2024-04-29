package com.pos.encode.com.pos.encode.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.pos.encode.ui.theme.DP
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.boldFontFamily

object CommonUiUtil {

    @Composable
    fun showTopBar(content: @Composable RowScope.() -> Unit) {
        val modifier = Modifier.fillMaxWidth().height(DP.topBarHeight).background(POSTheme.colors.topBarBackground)
        Row(modifier = modifier, content = content)
    }

    @Composable
    fun showHintText(text: String) {
        val modifier = Modifier.padding(start = DP.marginStart, top = DP.marginTop)
        Text(modifier = modifier, text = text, fontSize = DP.descriptionSize, fontFamily = boldFontFamily, textAlign = TextAlign.Center, color = POSTheme.colors.contentText)
    }

    @Composable
    fun horizontalDivider() {
        Divider(thickness = DP.dividerHeight, color = POSTheme.colors.divider)
    }

}