package com.pos.encode.com.pos.encode.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.pos.encode.Algorithm
import com.pos.encode.com.pos.encode.ui.widget.RadioGroupUtil
import com.pos.encode.ui.theme.DP
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.Strings
import com.pos.encode.ui.theme.boldFontFamily
import com.pos.encode.ui.widget.ButtonHelper

object CommonUiUtil {

    @Composable
    fun showInputDataFormatView(formatterText: MutableState<String>) {
        val content = @Composable {
            val modifier = Modifier.fillMaxWidth().padding(top = ButtonHelper.TEXT_MARGIN_BORDER)
            Row(modifier) {
                RadioGroupUtil.showRadioButton(Strings.data_format_ascii, formatterText.value == Algorithm.ASCII) { formatterText.value = Algorithm.ASCII }
                RadioGroupUtil.showRadioButton(Strings.data_format_hexadecimal, formatterText.value == Algorithm.HEXADECIMAL) { formatterText.value = Algorithm.HEXADECIMAL }
            }
        }
        RadioGroupUtil.showRadioGroup(Strings.data_format, content = content)
    }

    @Composable
    fun showEncryptionModeView(modeText: MutableState<String>) {
        val content = @Composable {
            val modifier = Modifier.fillMaxWidth().padding(top = ButtonHelper.TEXT_MARGIN_BORDER)
            Row(modifier) {
                RadioGroupUtil.showRadioButton(Strings.mode_ECB, modeText.value == Algorithm.MODE_ECB) { modeText.value = Algorithm.MODE_ECB }
                RadioGroupUtil.showRadioButton(Strings.mode_ECB, modeText.value == Algorithm.MODE_CBC) { modeText.value = Algorithm.MODE_CBC }
                RadioGroupUtil.showRadioButton(Strings.mode_CFB, modeText.value == Algorithm.MODE_CFB) { modeText.value = Algorithm.MODE_CFB }
                RadioGroupUtil.showRadioButton(Strings.mode_OFB, modeText.value == Algorithm.MODE_OFB) { modeText.value = Algorithm.MODE_OFB }
            }
        }
        RadioGroupUtil.showRadioGroup(Strings.mode, content = content)
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