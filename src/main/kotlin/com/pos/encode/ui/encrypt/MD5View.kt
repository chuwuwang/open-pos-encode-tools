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
import com.pos.encode.ui.helper.valid
import com.pos.encode.ui.theme.DP
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.Strings
import com.pos.encode.ui.widget.DialogHelper
import com.pos.encode.util.ByteUtil

object MD5View {

    @Composable
    fun preview(modifier: Modifier) {
        val inputText = remember { mutableStateOf("") }
        val outputText = remember { mutableStateOf("") }
        val algorithmType = remember { mutableStateOf(0) }
        val dataFormatter = remember { mutableStateOf(0) }
        val visibleDialog = remember { mutableStateOf(false) }
        Column(modifier) {
            var params = Modifier.fillMaxWidth().height(DP.topBarHeight).background(POSTheme.colors.topBarBackground)
            Row(params) {
                topItem(Modifier.weight(1.0f), Strings.hash_md2, 0, algorithmType.value) { algorithmType.value = 0 }
                topItem(Modifier.weight(1.0f), Strings.hash_md4, 1, algorithmType.value) { algorithmType.value = 1 }
                topItem(Modifier.weight(1.0f), Strings.hash_md5, 2, algorithmType.value) { algorithmType.value = 2 }
            }
            topBarDivider()
            modeSelectionWidget(Modifier.fillMaxWidth().padding(DP.padding, DP.topPadding, 56.dp, 0.dp), Strings.data_format) {
                params = Modifier.height(DP.itemHeight).padding(0.dp, 10.dp, 0.dp, 0.dp)
                Row(params) {
                    singleSelectButton(Modifier.weight(1.0f).fillMaxHeight(), Strings.data_format_ascii, dataFormatter.value == 1) { dataFormatter.value = 1 }
                    singleSelectButton(Modifier.weight(1.0f).fillMaxHeight(), Strings.data_format_hexadecimal, dataFormatter.value == 0) { dataFormatter.value = 0 }
                }
            }
            dataInputTextField(Modifier.weight(3.0f).padding(0.dp, DP.innerPadding, 0.dp, 0.dp), Strings.data_input, inputText.value, Int.MAX_VALUE) { inputText.value = it }
            dataInputTextField(Modifier.weight(1.0f).padding(0.dp, DP.innerPadding, 0.dp, 0.dp), Strings.data_output, outputText.value, Int.MAX_VALUE) { outputText.value = it }
            params = Modifier.fillMaxWidth().padding(DP.padding, DP.padding, DP.padding, DP.bottomPadding)
            Row(params) {
                encryptButton {
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
            outputText.value = Strings.error_encryption_failed
        }
    }

}