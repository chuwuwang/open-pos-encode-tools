package com.pos.encode.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pos.encode.ui.theme.DP
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.boldFontFamily
import com.pos.encode.ui.theme.mediumFontFamily



@Composable
fun modeSelectionWidget(modifier: Modifier, text: String, height: Dp = 72.dp, borderWidth: Dp = 1.5.dp, borderColor: Color = POSTheme.colors.borderChecked, content: @Composable () -> Unit) {
    Box(modifier = modifier.height(height).fillMaxWidth(), contentAlignment = Alignment.Center) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Divider(Modifier.width(DP.paddingStart).height(borderWidth), color = borderColor)
                Text(modifier = Modifier.padding(4.dp, 0.dp), fontSize = DP.contentSize, color = POSTheme.colors.contentText, text = text, fontFamily = boldFontFamily)
                Divider(Modifier.fillMaxWidth().height(borderWidth), color = borderColor)
            }
            val maxHeight = Modifier.weight(1.0f)
            Spacer(maxHeight)
            Divider(Modifier.fillMaxWidth().height(borderWidth), color = borderColor)
        }
        Row(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp), horizontalArrangement = Arrangement.Start) {
            Divider(Modifier.width(borderWidth).fillMaxHeight(), color = borderColor)
            val maxHeight = Modifier.weight(1.0f)
            Spacer(maxHeight)
            Divider(Modifier.width(borderWidth).fillMaxHeight(), color = borderColor)
        }
        content()
    }
}

@Composable
fun singleSelectButton(modifier: Modifier, text: String, selected: Boolean, onClick: () -> Unit) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = selected, colors = RadioButtonDefaults.colors(POSTheme.colors.button), onClick = onClick)
        Text(fontSize = DP.contentSize, color = POSTheme.colors.contentText, text = text, fontFamily = mediumFontFamily)
    }
}
