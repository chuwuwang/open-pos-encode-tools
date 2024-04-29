package com.pos.encode.ui.encrypt

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.pos.encode.Algorithm
import com.pos.encode.algorithm.MD5Util
import com.pos.encode.com.pos.encode.ui.CommonUiUtil
import com.pos.encode.com.pos.encode.ui.widget.ButtonUtil
import com.pos.encode.com.pos.encode.ui.widget.InputTextFieldUtil
import com.pos.encode.com.pos.encode.ui.widget.RadioGroupUtil
import com.pos.encode.ui.TopBar
import com.pos.encode.ui.TopBar.topBarItemView
import com.pos.encode.ui.helper.valid
import com.pos.encode.ui.theme.DP
import com.pos.encode.ui.theme.Strings
import com.pos.encode.ui.widget.ButtonHelper
import com.pos.encode.ui.widget.DialogHelper
import com.pos.encode.util.ByteUtil

object Md5AlgorithmActivity {

    private const val MD2 = 0
    private const val MD4 = 1
    private const val MD5 = 2

    @Composable
    fun preview(modifier: Modifier) {
        val algorithmText = remember { mutableStateOf(0) }
        val formatterText = remember { mutableStateOf(Algorithm.HEXADECIMAL) }

        val inputText = remember { mutableStateOf("") }
        val outputText = remember { mutableStateOf("") }
        val visibleDialog = remember { mutableStateOf(false) }

        Column(modifier) {
            showTopBar(algorithmText)

            CommonUiUtil.horizontalDivider()

            showInputDataFormatView(formatterText)

            CommonUiUtil.showHintText(Strings.data_input)
            val inputModifier = Modifier.weight(3.0f).padding(start = DP.marginStart, top = DP.paddingTop)
            InputTextFieldUtil.showInputTextFieldWithLength(inputModifier, inputText.value) { inputText.value = it }

            CommonUiUtil.showHintText(Strings.data_output)
            val outputModifier = Modifier.weight(1.0f).padding(start = DP.marginStart, top = DP.paddingTop)
            InputTextFieldUtil.showInputTextFieldWithLength(outputModifier, outputText.value) { outputText.value = it }

            val onButtonClickListener = {
                val text = inputText.value
                if (text.valid) {
                    hash(algorithmText.value, formatterText.value, text, outputText)
                } else {
                    visibleDialog.value = true
                }
            }
            val buttonModifier = Modifier.padding(DP.marginStart, DP.marginTop, DP.marginEnd, DP.marginBottom)
            ButtonUtil.showEncryptButton(buttonModifier, onButtonClickListener)

            DialogHelper.errorDialog(Strings.error_data, visibleDialog)
        }
    }

    @Composable
    private fun showTopBar(algorithmText: MutableState<Int>) {
        TopBar.showTopBar {
            topBarItemView(Strings.hash_md2, MD2, algorithmText.value) { algorithmText.value = MD2 }
            topBarItemView(Strings.hash_md4, MD4, algorithmText.value) { algorithmText.value = MD4 }
            topBarItemView(Strings.hash_md5, MD5, algorithmText.value) { algorithmText.value = MD5 }
        }
    }

    @Composable
    private fun showInputDataFormatView(formatterText: MutableState<String>) {
        val content = @Composable {
            val modifier = Modifier.fillMaxWidth().padding(top = ButtonHelper.TEXT_MARGIN_BORDER)
            Row(modifier) {
                RadioGroupUtil.radioButton(Strings.data_format_ascii, formatterText.value == Algorithm.ASCII) { formatterText.value = Algorithm.ASCII }
                RadioGroupUtil.radioButton(Strings.data_format_hexadecimal, formatterText.value == Algorithm.HEXADECIMAL) { formatterText.value = Algorithm.HEXADECIMAL }
            }
        }
        RadioGroupUtil.radioGroup(Strings.data_format, content = content)
    }

    private fun hash(type: Int, dataFormatter: String, data: String, outputText: MutableState<String>) {
        val dataBytes = if (dataFormatter == Algorithm.HEXADECIMAL) {
            ByteUtil.hexString2Bytes(data)
        } else {
            data.toByteArray(Charsets.US_ASCII)
        }
        val result = if (type == MD4) {
            MD5Util.md4(dataBytes)
        } else if (type == MD5) {
            MD5Util.md5(dataBytes)
        } else {
            MD5Util.md2(dataBytes)
        }
        if (result != null) {
            val hexString = ByteUtil.bytes2HexString(result)
            outputText.value = hexString
        } else {
            outputText.value = Strings.error_encryption_failed
        }
    }

}