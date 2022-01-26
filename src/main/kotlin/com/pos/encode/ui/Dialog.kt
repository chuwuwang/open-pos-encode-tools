package com.pos.encode.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.pos.encode.ui.theme.*

@Suppress("DEPRECATION")
@Composable
fun errorDialog(message: String, visible: MutableState<Boolean>) {
    Dialog(
        onCloseRequest = { visible.value = false },
        visible = visible.value,
        resizable = false,
        title = Strings.error.toUpperCase(),
        content = {
            val modifier = Modifier.fillMaxSize().background(POSTheme.colors.dialogBackground)
            Column(modifier) {
                Text(modifier = Modifier.padding(DP.dialogPadding, DP.dialogPadding, DP.dialogPadding, 0.dp), textAlign = TextAlign.Start, fontSize = DP.contentSize, color = POSTheme.colors.contentText, text = message, fontFamily = mediumFontFamily)
                Column(modifier = Modifier.fillMaxSize().padding(DP.dialogPadding), horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.Bottom) {
                    Column(modifier = Modifier.size(96.dp, 48.dp).background(POSTheme.colors.button).border(border = BorderStroke(0.dp, POSTheme.colors.button), shape = RectangleShape).clickable { visible.value = false }, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                        Text(textAlign = TextAlign.Center, fontSize = DP.contentSize, color = POSTheme.colors.iconChecked, text = Strings.ok.uppercase(), fontFamily = boldFontFamily)
                    }
                }
            }
        }
    )
}