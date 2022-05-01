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
import com.pos.encode.algorithm.SHAUtil
import com.pos.encode.ui.*
import com.pos.encode.ui.helper.valid
import com.pos.encode.ui.theme.DP
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.Strings
import com.pos.encode.ui.widget.ButtonHelper
import com.pos.encode.ui.widget.DialogHelper
import com.pos.encode.util.ByteUtil

object ShaView {

    private const val SHA_1 = 0
    private const val SHA_224 = 1
    private const val SHA_256 = 2
    private const val SHA_384 = 3
    private const val SHA_512 = 4

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
                TopBar.item(Modifier.weight(1.0f), Strings.hash_sha_1, SHA_1, algorithmType.value) { algorithmType.value = SHA_1 }
                TopBar.item(Modifier.weight(1.0f), Strings.hash_sha_224, SHA_224, algorithmType.value) { algorithmType.value = SHA_224 }
                TopBar.item(Modifier.weight(1.0f), Strings.hash_sha_256, SHA_256, algorithmType.value) { algorithmType.value = SHA_256 }
                TopBar.item(Modifier.weight(1.0f), Strings.hash_sha_384, SHA_384, algorithmType.value) { algorithmType.value = SHA_384 }
                TopBar.item(Modifier.weight(1.0f), Strings.hash_sha_512, SHA_512, algorithmType.value) { algorithmType.value = SHA_512 }
            }
            TopBar.divider()
            modeSelectionWidget(Modifier.fillMaxWidth().padding(DP.startPadding, DP.topPadding, 56.dp, 0.dp), Strings.data_format) {
                params = Modifier.height(DP.itemHeight).padding(0.dp, 10.dp, 0.dp, 0.dp)
                Row(params) {
                    singleSelectButton(Modifier.weight(1.0f).fillMaxHeight(), Strings.data_format_ascii, dataFormatter.value == Algorithm.ASCII) {
                        dataFormatter.value = Algorithm.ASCII
                    }
                    singleSelectButton(Modifier.weight(1.0f).fillMaxHeight(), Strings.data_format_hexadecimal, dataFormatter.value == Algorithm.HEXADECIMAL) {
                        dataFormatter.value = Algorithm.HEXADECIMAL
                    }
                }
            }
            dataInputTextField(Modifier.weight(3.0f).padding(0.dp, DP.innerPadding, 0.dp, 0.dp), Strings.data_input, inputText.value, Int.MAX_VALUE) { inputText.value = it }
            dataInputTextField(Modifier.weight(1.0f).padding(0.dp, DP.innerPadding, 0.dp, 0.dp), Strings.data_output, outputText.value, Int.MAX_VALUE) { outputText.value = it }
            params = Modifier.fillMaxWidth().padding(DP.startPadding, DP.topPadding, DP.endPadding, DP.bottomPadding)
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
            SHA_1 -> {
                result = SHAUtil.sha1(dataBytes)
            }
            SHA_224 -> {
                result = SHAUtil.sha224(dataBytes)
            }
            SHA_256 -> {
                result = SHAUtil.sha256(dataBytes)
            }
            SHA_384 -> {
                result = SHAUtil.sha384(dataBytes)
            }
            SHA_512 -> {
                result = SHAUtil.sha512(dataBytes)
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