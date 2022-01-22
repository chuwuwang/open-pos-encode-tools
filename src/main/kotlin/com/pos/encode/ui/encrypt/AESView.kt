package com.pos.encode.ui.encrypt

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.Strings
import com.pos.encode.ui.topBarDivider
import com.pos.encode.ui.topItem

@Composable
fun aesView(modifier: Modifier) {
    val current = remember { mutableStateOf(0) }
    Column(modifier) {
        val modifierNew = Modifier.fillMaxWidth().height(56.dp).background(POSTheme.colors.topBarBackground)
        Row(modifierNew) {
            topItem(Modifier.weight(1.0f), Strings.aes_128, 0, current.value) {
                current.value = 0
            }
            topItem(Modifier.weight(1.0f), Strings.aes_256, 1, current.value) {
                current.value = 1
            }
        }
        topBarDivider()
    }
}