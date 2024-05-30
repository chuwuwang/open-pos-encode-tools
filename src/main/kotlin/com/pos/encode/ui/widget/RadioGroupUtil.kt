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

object RadioGroupUtil {

    @Composable
    fun showRadioButton(text: String, selected: Boolean, onClick: () -> Unit) {
        Row(modifier = Modifier.width(192.dp).fillMaxHeight(), verticalAlignment = Alignment.CenterVertically) {
            val radioButtonColors = RadioButtonDefaults.colors(POSTheme.colors.button)
            RadioButton(onClick = onClick, selected = selected, colors = radioButtonColors)
            Text(text = text, fontSize = DP.contentSize, fontFamily = mediumFontFamily, color = POSTheme.colors.contentText)
        }
    }

    @Composable
    fun showRadioGroup(text: String, height: Dp = RADIO_GROUP_HEIGHT, content: @Composable () -> Unit) {
        val modifier = Modifier.fillMaxWidth().padding(DP.marginStart, DP.marginTop, InputTextFieldUtil.TEXT_LENGTH_WIDTH, 0.dp).height(height)
        Box(modifier = modifier, contentAlignment = Alignment.Center) {
            val leftWidth = 24.dp
            val borderWidth = DP.borderWidth
            val borderColor = POSTheme.colors.borderChecked
            // 从上到下绘制 divider
            Column {
                // top view
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // top left divider
                    Divider(modifier = Modifier.width(leftWidth).height(borderWidth), color = borderColor)
                    // hint text
                    Text(modifier = Modifier.padding(4.dp, 0.dp), fontSize = DP.contentSize, color = POSTheme.colors.contentText, text = text, fontFamily = boldFontFamily)
                    // top right divider
                    Divider(modifier = Modifier.fillMaxWidth().height(borderWidth), color = borderColor)
                }
                // 占满空间
                val spacerModifier = Modifier.weight(1.0f)
                Spacer(spacerModifier)
                // bottom divider
                Divider(modifier = Modifier.fillMaxWidth().height(borderWidth), color = borderColor)
            }
            // 从左到右绘制 divider
            Row(modifier = Modifier.padding(top = DP.paddingTop), horizontalArrangement = Arrangement.Start) {
                // left divider
                Divider(modifier = Modifier.width(borderWidth).fillMaxHeight(), color = borderColor)
                // 占满空间
                val spacerModifier = Modifier.weight(1.0f)
                Spacer(spacerModifier)
                // right divider
                Divider(modifier = Modifier.width(borderWidth).fillMaxHeight(), color = borderColor)
            }
            content()
        }
    }

}