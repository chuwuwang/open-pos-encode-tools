package com.pos.encode.ui.encrypt

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pos.encode.Algorithm
import com.pos.encode.algorithm.MD5Util
import com.pos.encode.ui.TopBar
import com.pos.encode.ui.helper.valid
import com.pos.encode.ui.theme.DP
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.Strings
import com.pos.encode.ui.widget.ButtonHelper
import com.pos.encode.ui.widget.DialogHelper
import com.pos.encode.ui.widget.TextFieldHelper
import com.pos.encode.util.ByteUtil

object MD5View {

    private const val MD2 = 0
    private const val MD4 = 1
    private const val MD5 = 2

    @Suppress("DuplicatedCode")
    @Composable
    fun preview(modifier: Modifier) {
        val inputText = remember { mutableStateOf("") }
        val outputText = remember { mutableStateOf("") }
        val algorithmType = remember { mutableStateOf(0) }
        val visibleDialog = remember { mutableStateOf(false) }
        val dataFormatter = remember { mutableStateOf(Algorithm.HEXADECIMAL) }
        Column(modifier) {
            var params = Modifier.fillMaxWidth().height(DP.topBarHeight).background(POSTheme.colors.topBarBackground)
            Row(params) {
                TopBar.item(Modifier.weight(1.0f), Strings.hash_md2, MD2, algorithmType.value) { algorithmType.value = MD2 }
                TopBar.item(Modifier.weight(1.0f), Strings.hash_md4, MD4, algorithmType.value) { algorithmType.value = MD4 }
                TopBar.item(Modifier.weight(1.0f), Strings.hash_md5, MD5, algorithmType.value) { algorithmType.value = MD5 }
            }
            TopBar.divider()
            ButtonHelper.radioGroup(Modifier.fillMaxWidth().padding(DP.paddingStart, DP.paddingTop, 56.dp, 0.dp), Strings.data_format) {
                params = Modifier.height(DP.itemHeight).padding(0.dp, 10.dp, 0.dp, 0.dp)
                Row(params) {
                    ButtonHelper.radioButton(Modifier.weight(1.0f).fillMaxHeight(), Strings.data_format_ascii, dataFormatter.value == Algorithm.ASCII) {
                        dataFormatter.value = Algorithm.ASCII
                    }
                    ButtonHelper.radioButton(Modifier.weight(1.0f).fillMaxHeight(), Strings.data_format_hexadecimal, dataFormatter.value == Algorithm.HEXADECIMAL) {
                        dataFormatter.value = Algorithm.HEXADECIMAL
                    }
                }
            }
            TextFieldHelper.inputTextField(Modifier.weight(3.0f).padding(0.dp, DP.innerPaddingTop, 0.dp, 0.dp), Strings.data_input, inputText.value, Int.MAX_VALUE) { inputText.value = it }
            TextFieldHelper.inputTextField(Modifier.weight(1.0f).padding(0.dp, DP.innerPaddingTop, 0.dp, 0.dp), Strings.data_output, outputText.value, Int.MAX_VALUE) { outputText.value = it }
            params = Modifier.fillMaxWidth().padding(DP.paddingStart, DP.paddingTop, DP.paddingEnd, DP.paddingBottom)
            Row(params) {
                ButtonHelper.encryptButton {
                    val text = inputText.value
                    if (text.valid) {
                        hash(algorithmType.value, dataFormatter.value, text, outputText)
                    } else {
                        visibleDialog.value = true
                    }
                }
            }
            DialogHelper.errorDialog(Strings.error_data, visibleDialog)
        }
    }

    private fun hash(type: Int, dataFormatter: String, data: String, outputText: MutableState<String>) {
        val dataBytes = if (dataFormatter == Algorithm.HEXADECIMAL) {
            ByteUtil.hexString2Bytes(data)
        } else {
            data.toByteArray(Charsets.US_ASCII)
        }
        var result: ByteArray ? = null
        when (type) {
            MD2 -> {
                result = MD5Util.md2(dataBytes)
            }
            MD4 -> {
                result = MD5Util.md4(dataBytes)
            }
            MD5 -> {
                result = MD5Util.md5(dataBytes)
            }
        }
        if (result != null) {
            val hexString = ByteUtil.bytes2HexString(result)
            outputText.value = hexString
        } else {
            outputText.value = Strings.error_encryption_failed
        }
    }

}