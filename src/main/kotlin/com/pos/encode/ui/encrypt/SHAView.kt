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
import com.pos.encode.ui.TopBar
import com.pos.encode.ui.helper.valid
import com.pos.encode.ui.theme.DP
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.Strings
import com.pos.encode.ui.widget.ButtonHelper
import com.pos.encode.ui.widget.DialogHelper
import com.pos.encode.ui.widget.TextFieldHelper
import com.pos.encode.util.ByteUtil

object SHAView {

    private const val SHA_1 = 0
    private const val SHA_224 = 1
    private const val SHA_256 = 2
    private const val SHA_384 = 3
    private const val SHA_512 = 4

    @Suppress("DuplicatedCode")
    @Composable
    fun preview(modifier: Modifier) {
        val algorithm = remember { mutableStateOf(0) }
        val formatter = remember { mutableStateOf(Algorithm.HEXADECIMAL) }

        val inputText = remember { mutableStateOf("") }
        val outputText = remember { mutableStateOf("") }
        val visibleDialog = remember { mutableStateOf(false) }

        Column(modifier) {
            var params = Modifier.fillMaxWidth().height(DP.topBarHeight).background(POSTheme.colors.topBarBackground)
            Row(params) {
                TopBar.item(Modifier.weight(1.0f), Strings.hash_sha_1, SHA_1, algorithm.value) { algorithm.value = SHA_1 }
                TopBar.item(Modifier.weight(1.0f), Strings.hash_sha_224, SHA_224, algorithm.value) { algorithm.value = SHA_224 }
                TopBar.item(Modifier.weight(1.0f), Strings.hash_sha_256, SHA_256, algorithm.value) { algorithm.value = SHA_256 }
                TopBar.item(Modifier.weight(1.0f), Strings.hash_sha_384, SHA_384, algorithm.value) { algorithm.value = SHA_384 }
                TopBar.item(Modifier.weight(1.0f), Strings.hash_sha_512, SHA_512, algorithm.value) { algorithm.value = SHA_512 }
            }

            TopBar.divider()

            ButtonHelper.radioGroup(Modifier.fillMaxWidth().padding(DP.marginStart, DP.marginTop, TextFieldHelper.HINT_TEXT_WIDTH, 0.dp), Strings.data_format) {
                params = Modifier.fillMaxWidth().padding(0.dp, ButtonHelper.TEXT_MARGIN_BORDER, 0.dp, 0.dp)
                Row(params) {
                    ButtonHelper.radioButton(Strings.data_format_ascii, formatter.value == Algorithm.ASCII) {
                        formatter.value = Algorithm.ASCII
                    }
                    ButtonHelper.radioButton(Strings.data_format_hexadecimal, formatter.value == Algorithm.HEXADECIMAL) {
                        formatter.value = Algorithm.HEXADECIMAL
                    }
                }
            }

            TextFieldHelper.inputTextField(Modifier.weight(3.0f).padding(0.dp, DP.paddingTop, 0.dp, 0.dp), Strings.data_input, inputText.value, Int.MAX_VALUE) { inputText.value = it }

            TextFieldHelper.inputTextField(Modifier.weight(1.0f).padding(0.dp, DP.paddingTop, 0.dp, 0.dp), Strings.data_output, outputText.value, Int.MAX_VALUE) { outputText.value = it }

            params = Modifier.fillMaxWidth().padding(DP.marginStart, DP.marginTop, DP.marginEnd, DP.marginBottom)
            Row(params) {
                ButtonHelper.encryptButton {
                    val text = inputText.value
                    if (text.valid) {
                        hash(algorithm.value, formatter.value, text, outputText)
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