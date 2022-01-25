package com.pos.encode.ui.encrypt

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pos.encode.ui.*
import com.pos.encode.ui.theme.DP
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.Strings

@Composable
fun hashView(modifier: Modifier) {
    val current = remember { mutableStateOf(0) }
    val inputText = remember { mutableStateOf("") }
    val outputText = remember { mutableStateOf("") }
    Column(modifier) {
        var modifierNew = Modifier.fillMaxWidth().height(DP.topBarHeight).background(POSTheme.colors.topBarBackground)
        Row(modifierNew) {
            topItem(Modifier.weight(1.0f), Strings.hash_md5, 0, current.value) {
                current.value = 0
            }
            topItem(Modifier.weight(1.0f), Strings.hash_sha_1, 1, current.value) {
                current.value = 1
            }
            topItem(Modifier.weight(1.0f), Strings.hash_sha_128, 2, current.value) {
                current.value = 2
            }
            topItem(Modifier.weight(1.0f), Strings.hash_sha_256, 3, current.value) {
                current.value = 3
            }
            topItem(Modifier.weight(1.0f), Strings.hash_sha_512, 4, current.value) {
                current.value = 4
            }
        }
        topBarDivider()
        modifierNew = Modifier.weight(1.0f).padding(0.dp, DP.padding, 0.dp, 0.dp)
        dataInputTextField(modifierNew, Strings.data_input, inputText.value, Int.MAX_VALUE) { inputText.value = it }
        dataInputTextField(modifierNew, Strings.data_output, outputText.value, Int.MAX_VALUE) { outputText.value = it }
        modifierNew = Modifier.fillMaxWidth().padding(120.dp, DP.padding, DP.padding, DP.bottomPadding)
        Row(modifierNew) {
            encryptButton { }
            decryptButton { }
        }
    }
}

