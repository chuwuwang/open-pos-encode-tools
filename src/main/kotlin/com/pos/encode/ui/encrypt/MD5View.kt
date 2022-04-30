package com.pos.encode.ui.encrypt

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pos.encode.algorithm.MD5Util
import com.pos.encode.ui.*
import com.pos.encode.ui.helper.empty
import com.pos.encode.ui.theme.DP
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.Strings
import com.pos.encode.util.ByteUtil

object MD5View {

    @Composable
    fun preview(modifier: Modifier) {
        val current = remember { mutableStateOf(0) }
        val dataFormat = remember { mutableStateOf(0) }
        val inputText = remember { mutableStateOf("") }
        val outputText = remember { mutableStateOf("") }
        val hasDialog = remember { mutableStateOf(false) }
        Column(modifier) {
            var params = Modifier.fillMaxWidth().height(DP.topBarHeight).background(POSTheme.colors.topBarBackground)
            Row(params) {
                topItem(Modifier.weight(1.0f), Strings.hash_md2, 0, current.value) { current.value = 0 }
                topItem(Modifier.weight(1.0f), Strings.hash_md4, 1, current.value) { current.value = 1 }
                topItem(Modifier.weight(1.0f), Strings.hash_md5, 2, current.value) { current.value = 2 }
            }
            topBarDivider()
            modeSelectionWidget(Modifier.fillMaxWidth().padding(DP.padding, DP.topPadding, 56.dp, 0.dp), Strings.data_format) {
                params = Modifier.height(DP.itemHeight).padding(0.dp, 10.dp, 0.dp, 0.dp)
                Row(params) {
                    singleSelectButton(Modifier.weight(1.0f).fillMaxHeight(), Strings.data_format_ascii, dataFormat.value == 1) { dataFormat.value = 1 }
                    singleSelectButton(Modifier.weight(1.0f).fillMaxHeight(), Strings.data_format_hexadecimal, dataFormat.value == 0) { dataFormat.value = 0 }
                }
            }
            dataInputTextField(Modifier.weight(3.0f).padding(0.dp, DP.innerPadding, 0.dp, 0.dp), Strings.data_input, inputText.value, Int.MAX_VALUE) { inputText.value = it }
            dataInputTextField(Modifier.weight(1.0f).padding(0.dp, DP.innerPadding, 0.dp, 0.dp), Strings.data_output, outputText.value, Int.MAX_VALUE) { outputText.value = it }
            params = Modifier.fillMaxWidth().padding(DP.padding, DP.padding, DP.padding, DP.bottomPadding)
            Row(params) {
                encryptButton {
                    val text = inputText.value
                    if (text.empty) {
                        hasDialog.value = true
                        return@encryptButton
                    } else {
                        hash(current.value, dataFormat.value, text, outputText)
                    }
                }
            }
            errorDialog(Strings.error_data, hasDialog)
        }
    }

    private fun hash(type: Int, dataFormat: Int, data: String, outputText: MutableState<String>) {
        val dataBytes = if (dataFormat == 0) {
            ByteUtil.hexString2Bytes(data)
        } else {
            data.toByteArray(Charsets.US_ASCII)
        }
        var result: ByteArray ? = null
        when (type) {
            0 -> {
                result = MD5Util.md2(dataBytes)
            }
            1 -> {
                result = MD5Util.md4(dataBytes)
            }
            2 -> {
                result = MD5Util.md5(dataBytes)
            }
        }
        if (result != null) {
            val hexString = ByteUtil.bytes2HexString(result)
            outputText.value = hexString
        } else {
            outputText.value = "加密失败"
        }
    }

}