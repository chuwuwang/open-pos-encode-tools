package com.pos.encode.ui.encrypt

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pos.encode.Algorithm
import com.pos.encode.ui.TopBar
import com.pos.encode.ui.helper.valid
import com.pos.encode.ui.theme.DP
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.Strings
import com.pos.encode.ui.widget.ButtonHelper
import com.pos.encode.ui.widget.TextFieldHelper

object DESView {

    private const val DES_DES = 0
    private const val DES_3DES = 1
    private const val PADDING_NoPadding = "NoPadding"
    private const val PADDING_TBCPadding = "TBCPadding"
    private const val PADDING_X923Padding = "X923Padding"
    private const val PADDING_PKCS5Padding = "PKCS5Padding"
    private const val PADDING_PKCS7Padding = "PKCS7Padding"
    private const val PADDING_ZeroBytePadding = "ZeroBytePadding"
    private const val PADDING_ISO10126Padding = "ISO10126Padding"
    private const val PADDING_ISO7816d4Padding = "ISO7816d4Padding"
    private const val PADDING_ISO10126d2Padding = "ISO10126d2Padding"

    @Suppress("DuplicatedCode")
    @Composable
    fun preview(modifier: Modifier) {
        val algorithm = remember { mutableStateOf(0) }
        val mode = remember { mutableStateOf(Algorithm.MODE_ECB) }
        val padding = remember { mutableStateOf(PADDING_NoPadding) }
        val formatter = remember { mutableStateOf(Algorithm.HEXADECIMAL) }

        val inputText = remember { mutableStateOf("") }
        val outputText = remember { mutableStateOf("") }
        val visibleDialog = remember { mutableStateOf(false) }

        Column(modifier) {
            var params = Modifier.fillMaxWidth().height(DP.topBarHeight).background(POSTheme.colors.topBarBackground)
            Row(params) {
                TopBar.item(Modifier.weight(1.0f), Strings.des3des_des, DES_DES, algorithm.value) { algorithm.value = DES_DES }
                TopBar.item(Modifier.weight(1.0f), Strings.des3des_3des, DES_3DES, algorithm.value) { algorithm.value = DES_3DES }
            }

            TopBar.divider()

            ButtonHelper.radioGroup(Modifier.fillMaxWidth().padding(DP.paddingStart, DP.paddingTop, TextFieldHelper.HINT_TEXT_WIDTH, 0.dp), Strings.mode) {
                params = Modifier.fillMaxHeight().fillMaxWidth().padding(0.dp, ButtonHelper.TEXT_MARGIN_BORDER, 0.dp, 0.dp)
                Row(params) {
                    ButtonHelper.radioButton(Strings.mode_ECB, mode.value == Algorithm.MODE_ECB) {
                        mode.value = Algorithm.MODE_ECB
                    }
                    ButtonHelper.radioButton(Strings.mode_ECB, mode.value == Algorithm.MODE_CBC) {
                        mode.value = Algorithm.MODE_CBC
                    }
                    ButtonHelper.radioButton(Strings.mode_CFB, mode.value == Algorithm.MODE_CFB) {
                        mode.value = Algorithm.MODE_CFB
                    }
                    ButtonHelper.radioButton(Strings.mode_OFB, mode.value == Algorithm.MODE_OFB) {
                        mode.value = Algorithm.MODE_OFB
                    }
                }
            }

            ButtonHelper.radioGroup(Modifier.fillMaxWidth().padding(DP.paddingStart, DP.paddingTop, TextFieldHelper.HINT_TEXT_WIDTH, 0.dp), Strings.padding, ButtonHelper.RADIO_GROUP_HEIGHT + 64.dp) {
                Column {
                    params = Modifier.height(ButtonHelper.RADIO_GROUP_HEIGHT).fillMaxWidth().padding(0.dp, ButtonHelper.TEXT_MARGIN_BORDER, 0.dp, 0.dp)
                    Row(params) {
                        ButtonHelper.radioButton(Strings.padding_No, padding.value == PADDING_NoPadding) {
                            padding.value = PADDING_NoPadding
                        }
                        ButtonHelper.radioButton(Strings.padding_PKCS5, padding.value == PADDING_PKCS5Padding) {
                            padding.value = PADDING_PKCS5Padding
                        }
                        ButtonHelper.radioButton(Strings.padding_PKCS7, padding.value == PADDING_PKCS7Padding) {
                            padding.value = PADDING_PKCS7Padding
                        }
                        ButtonHelper.radioButton(Strings.padding_ZeroByte, padding.value == PADDING_ZeroBytePadding) {
                            padding.value = PADDING_ZeroBytePadding
                        }
                        ButtonHelper.radioButton(Strings.padding_TBC, padding.value == PADDING_TBCPadding) {
                            padding.value = PADDING_TBCPadding
                        }
                    }
                    params = Modifier.height(64.dp).fillMaxWidth()
                    Row(params) {
                        ButtonHelper.radioButton(Strings.padding_X923, padding.value == PADDING_X923Padding) {
                            padding.value = PADDING_X923Padding
                        }
                        ButtonHelper.radioButton(Strings.padding_ISO7816d4, padding.value == PADDING_ISO7816d4Padding) {
                            padding.value = PADDING_ISO7816d4Padding
                        }
                        ButtonHelper.radioButton(Strings.padding_ISO10126, padding.value == PADDING_ISO10126Padding) {
                            padding.value = PADDING_ISO10126Padding
                        }
                        ButtonHelper.radioButton(Strings.padding_ISO10126d2, padding.value == PADDING_ISO10126d2Padding) {
                            padding.value = PADDING_ISO10126d2Padding
                        }
                    }
                }
            }

            ButtonHelper.radioGroup(Modifier.fillMaxWidth().padding(DP.paddingStart, DP.paddingTop, TextFieldHelper.HINT_TEXT_WIDTH, 0.dp), Strings.data_format) {
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

            TextFieldHelper.inputTextField(Modifier.weight(3.0f).padding(0.dp, DP.innerPaddingTop, 0.dp, 0.dp), Strings.data_input, inputText.value, Int.MAX_VALUE) { inputText.value = it }

            TextFieldHelper.inputTextField(Modifier.weight(1.0f).padding(0.dp, DP.innerPaddingTop, 0.dp, 0.dp), Strings.data_output, outputText.value, Int.MAX_VALUE) { outputText.value = it }

            params = Modifier.fillMaxWidth().padding(DP.paddingStart, DP.paddingTop, DP.paddingEnd, DP.paddingBottom)
            Row(params) {
                ButtonHelper.encryptButton {
                    val text = inputText.value
                    if (text.valid) {

                    } else {
                        visibleDialog.value = true
                    }
                }
                ButtonHelper.decryptButton {

                }
            }

        }
    }

}