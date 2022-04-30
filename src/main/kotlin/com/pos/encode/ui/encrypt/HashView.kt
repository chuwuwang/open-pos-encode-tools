package com.pos.encode.ui.encrypt

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pos.encode.ui.*
import com.pos.encode.ui.helper.empty
import com.pos.encode.ui.theme.DP
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.Strings
import com.pos.encode.ui.widget.DialogHelper

@Composable
fun hashView(modifier: Modifier) {
    val current = remember { mutableStateOf(0) }
    val dataFormat = remember { mutableStateOf(0) }
    val inputText = remember { mutableStateOf("") }
    val outputText = remember { mutableStateOf("") }
    val hasDialog = remember { mutableStateOf(false) }
    Column(modifier) {
        var modifierNew = Modifier.fillMaxWidth().height(DP.topBarHeight).background(POSTheme.colors.topBarBackground)
        Row(modifierNew) {
            topItem(Modifier.weight(1.0f), Strings.hash_md5, 0, current.value) { current.value = 0 }
            topItem(Modifier.weight(1.0f), Strings.hash_sha_1, 1, current.value) { current.value = 1 }
            topItem(Modifier.weight(1.0f), Strings.hash_sha_256, 3, current.value) { current.value = 3 }
            topItem(Modifier.weight(1.0f), Strings.hash_sha_384, 2, current.value) { current.value = 2 }
            topItem(Modifier.weight(1.0f), Strings.hash_sha_512, 4, current.value) { current.value = 4 }
        }
        topBarDivider()
        modeSelectionWidget(Modifier.fillMaxWidth().padding(DP.padding, DP.topPadding, 56.dp, 0.dp), Strings.data_format) {
            val padding = Modifier.height(DP.itemHeight).padding(0.dp, 10.dp, 0.dp, 0.dp)
            Row(padding) {
                modifierNew = Modifier.weight(1.0f).fillMaxHeight()
                singleSelectButton(modifierNew, Strings.data_format_ascii, dataFormat.value == 1) { dataFormat.value = 1 }
                singleSelectButton(modifierNew, Strings.data_format_hexadecimal, dataFormat.value == 0) { dataFormat.value = 0 }
            }
        }
        modifierNew = Modifier.weight(3.0f).padding(0.dp, DP.innerPadding, 0.dp, 0.dp)
        dataInputTextField(modifierNew, Strings.data_input, inputText.value, Int.MAX_VALUE) { inputText.value = it }
        modifierNew = Modifier.weight(1.0f).padding(0.dp, DP.innerPadding, 0.dp, 0.dp)
        dataInputTextField(modifierNew, Strings.data_output, outputText.value, Int.MAX_VALUE) { outputText.value = it }
        modifierNew = Modifier.fillMaxWidth().padding(DP.padding, DP.padding, DP.padding, DP.bottomPadding)
        Row(modifierNew) {
            encryptButton {
                val text = inputText.value
                if (text.empty) {
                    hasDialog.value = true
                    return@encryptButton
                }
            }
        }
        DialogHelper.errorDialog(Strings.error_data, hasDialog)
    }
}

private fun hashCalculator(text: String) {

}
