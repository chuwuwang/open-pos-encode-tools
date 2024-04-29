package com.pos.encode.com.pos.encode.ui.widget

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pos.encode.ui.theme.DP
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.boldFontFamily
import com.pos.encode.ui.theme.mediumFontFamily
import com.pos.encode.ui.widget.ButtonHelper.RADIO_GROUP_HEIGHT
import com.pos.encode.ui.widget.TextFieldHelper

object RadioGroupUtil {

    @Composable
    fun radioButton(text: String, selected: Boolean, onClick: () -> Unit) {
        Row(modifier = Modifier.width(192.dp).fillMaxHeight(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                onClick = onClick, selected = selected, colors = RadioButtonDefaults.colors(POSTheme.colors.button)
            )
            Text(
                text = text,
                fontSize = DP.contentSize,
                fontFamily = mediumFontFamily,
                color = POSTheme.colors.contentText
            )
        }
    }

    @Composable
    fun radioGroup(text: String, height: Dp = RADIO_GROUP_HEIGHT, content: @Composable () -> Unit) {
        val borderWidth = DP.borderWidth
        val borderColor = POSTheme.colors.borderChecked
        Box(modifier = Modifier.fillMaxWidth().padding(DP.marginStart, DP.marginTop, TextFieldHelper.HINT_TEXT_WIDTH, 0.dp).height(height), contentAlignment = Alignment.Center) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Divider(modifier = Modifier.width(24.dp).height(borderWidth), color = borderColor)
                    Text(modifier = Modifier.padding(4.dp, 0.dp), fontSize = DP.contentSize, color = POSTheme.colors.contentText, text = text, fontFamily = boldFontFamily)
                    Divider(modifier = Modifier.fillMaxWidth().height(borderWidth), color = borderColor)
                }
                val params = Modifier.weight(1.0f)
                Spacer(params)
                Divider(modifier = Modifier.fillMaxWidth().height(borderWidth), color = borderColor)
            }
            Row(modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 0.dp), horizontalArrangement = Arrangement.Start) {
                Divider(modifier = Modifier.width(borderWidth).fillMaxHeight(), color = borderColor)
                val params = Modifier.weight(1.0f)
                Spacer(params)
                Divider(modifier = Modifier.width(borderWidth).fillMaxHeight(), color = borderColor)
            }
            content()
        }
    }

}